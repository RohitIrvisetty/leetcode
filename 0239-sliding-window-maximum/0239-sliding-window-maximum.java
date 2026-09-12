class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {

            pq.offer(new int[]{nums[i], i});

            // Remove elements that are outside the window
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            if (i >= k - 1) {
                result.add(pq.peek()[0]);
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}