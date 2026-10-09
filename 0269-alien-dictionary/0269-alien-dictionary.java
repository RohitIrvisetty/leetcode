class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for (String word: words) {
            for (Character ch: word.toCharArray()) {
                inDegree.put(ch, 0);
                adjList.put(ch, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String currWord = words[i];
            String nextWord = words[i + 1];

            if (currWord.length() > nextWord.length() && currWord.startsWith(nextWord)) {
                return "";
            }

            for (int j = 0; j < Math.min(currWord.length(), nextWord.length()); j++) {
                if (currWord.charAt(j) != nextWord.charAt(j)) {
                    adjList.get(currWord.charAt(j)).add(nextWord.charAt(j));
                    inDegree.put(nextWord.charAt(j), inDegree.get(nextWord.charAt(j)) + 1);
                    break;
                }
            }
        }

        for (char ch: inDegree.keySet()) {
            if (inDegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);

            for (char ch: adjList.get(curr)) {
                inDegree.put(ch, inDegree.get(ch) - 1);

                if (inDegree.get(ch) == 0) {
                    queue.offer(ch);
                }
            }
        }

        if (sb.length() < inDegree.size()) {
            return "";
        }
        return sb.toString();
    }
}