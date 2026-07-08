import java.util.*;

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Store how many rocks each bag needs
        for (int i = 0; i < capacity.length; i++) {
            pq.offer(capacity[i] - rocks[i]);
        }

        int count = 0;

        // Always fill the bag requiring the least rocks
        while (!pq.isEmpty()) {
            int needed = pq.poll();

            if (additionalRocks >= needed) {
                additionalRocks -= needed;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}