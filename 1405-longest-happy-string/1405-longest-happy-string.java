class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[1] - x[1]);

        if (a > 0) {
            maxHeap.offer(new int[] {0, a});
        }

        if (b > 0) {
            maxHeap.offer(new int[] {1, b});
        }

        if (c > 0) {
            maxHeap.offer(new int[] {2, c});
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = null;
        //Integer[] prev2 = null;
        int contigousCount = 0;

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();

            if (prev == null) {
                //prev = curr;
                contigousCount = 1;
                curr[1]--;
                sb.append((char) ('a' + curr[0]));
                
                prev = curr;

                if (curr[1] > 0) {
                    maxHeap.offer(curr);
                }
            } else if (prev != null && prev[0] == curr[0] && contigousCount >= 2) {
                contigousCount = 1;

                if (maxHeap.size() == 0) {
                    return sb.toString();
                }
                int[] next = maxHeap.poll();
                next[1]--;
                sb.append((char) ('a' + next[0]));
                prev = next;
                
                if (next[1] > 0) {
                    maxHeap.offer(next);
                }

                maxHeap.offer(curr);
            } else if (prev != null && prev[0] == curr[0] && contigousCount < 2) {
                contigousCount++;
                curr[1]--;

                sb.append((char) ('a' + curr[0]));

                if (curr[1] > 0) {
                    maxHeap.offer(curr);
                }
            } else {
                contigousCount = 1;
                curr[1]--;
                sb.append((char) ('a' + curr[0]));
                
                prev = curr;

                if (curr[1] > 0) {
                    maxHeap.offer(curr);
                }
            }
        }
        return sb.toString();
    }
}