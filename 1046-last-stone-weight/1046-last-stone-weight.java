class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone: stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if (stone1 == stone2) {
                continue;
            }

            if (stone1 < stone2) {
                pq.add(stone2 - stone1);
            } else {
                pq.add(stone1 - stone2);
            }
        }

        if (pq.size() == 0) {
            return 0;
        }
        
        return pq.peek();
    }
}