class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dictionary = new HashSet<>(wordList);

        if (!dictionary.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return steps + 1;
                }

                for (int j = 0; j < word.length(); j++) {

                    for (char c = 'a'; c <= 'z'; c++) {

                        String newWord = word.substring(0, j) + c + word.substring(j + 1);

                        if (dictionary.contains(newWord)) {
                            queue.offer(newWord);
                            dictionary.remove(newWord);
                        }
                    }
                }
            }

            steps++;
        }

        return 0;
    }
}