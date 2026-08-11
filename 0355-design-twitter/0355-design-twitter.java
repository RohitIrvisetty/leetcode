class Twitter {
    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (tweetMap.containsKey(userId)) {
            tweetMap.get(userId).add(new int[] {time++, tweetId});
            if (tweetMap.get(userId).size() > 10) {
                tweetMap.get(userId).remove(0);
            }
        } else {
            tweetMap.put(userId, new ArrayList<>());
            tweetMap.get(userId).add(new int[]{time++, tweetId});
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followers = followMap.getOrDefault(userId, new HashSet<>());
        followers.add(userId);

        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int followeeId : followers) {
            if (tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int lastIndex = tweets.size() - 1;
                int[] tweet = tweets.get(lastIndex);

                minHeap.offer(new int[] {tweet[0], tweet[1], followeeId, lastIndex});
                if (minHeap.size() > 10) {
                    minHeap.poll();
                }
            }
        }

        while(!minHeap.isEmpty()) {
            int[] tweet = minHeap.poll();
            maxHeap.offer(new int[] {tweet[0], tweet[1], tweet[2], tweet[3]});
        }

        while (!maxHeap.isEmpty() && ans.size() < 10) {
            int[] tweet = maxHeap.poll();

            int index = tweet[3];
            int nextIndex = index - 1;
            ans.add(tweet[1]);

            if (nextIndex >= 0) {
                int[] nextTweet = tweetMap.get(tweet[2]).get(nextIndex);
                maxHeap.offer(new int[] {nextTweet[0], nextTweet[1], tweet[2], nextIndex});
            }
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            if (followMap.containsKey(followerId)) {
                followMap.get(followerId).add(followeeId);
            } else {
                followMap.put(followerId, new HashSet<>());
                followMap.get(followerId).add(followeeId);
            }
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            if (followMap.containsKey(followerId)) {
                followMap.get(followerId).remove(followeeId);
            }
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */