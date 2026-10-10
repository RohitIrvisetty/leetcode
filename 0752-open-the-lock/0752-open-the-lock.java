class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<String>();
        Set<String> seen = new HashSet<>();
        char[] slots = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        Map<Character, Character> nextSlot = Map.of(
                '0', '1',
                '1', '2',
                '2', '3',
                '3', '4',
                '4', '5',
                '5', '6',
                '6', '7',
                '7', '8',
                '8', '9',
                '9', '0');
        Map<Character, Character> prevSlot = Map.of(
                '0', '9',
                '1', '0',
                '2', '1',
                '3', '2',
                '4', '3',
                '5', '4',
                '6', '5',
                '7', '6',
                '8', '7',
                '9', '8');
        int steps = 0;
        queue.offer("0000");
        seen.add("0000");

        if (Arrays.asList(deadends).contains("0000")) {
            return -1;
        }
        
        while (!queue.isEmpty()) {
            int currQueueSize = queue.size();
            for (int l = 0; l < currQueueSize; l++) {
                String currComb = queue.poll();
                if (currComb.equals(target)) {
                    return steps;
                }

                for (int j = 0; j < currComb.length(); j++) {
                    String forward = currComb.substring(0, j) + nextSlot.get(currComb.charAt(j)) + currComb.substring(j + 1);

                    if (!seen.contains(forward) && !Arrays.asList(deadends).contains(forward)) {
                        queue.offer(forward);
                        seen.add(forward);
                    }

                    String backward = currComb.substring(0, j) + prevSlot.get(currComb.charAt(j)) + currComb.substring(j + 1);

                    if (!seen.contains(backward) && !Arrays.asList(deadends).contains(backward)) {
                        queue.offer(backward);
                        seen.add(backward);
                    }
                }

            }
            steps++;
        }

        return -1;
    }
}