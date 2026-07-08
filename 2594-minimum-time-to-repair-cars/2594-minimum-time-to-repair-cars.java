class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = (long) ranks[0] * cars * cars; // worst case: fastest mechanic repairs all cars
        
        // Find maximum rank for upper bound
        int minRank = Integer.MAX_VALUE;
        for (int r : ranks) {
            minRank = Math.min(minRank, r);
        }
        high = (long) minRank * cars * cars;

        long answer = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canRepair(ranks, cars, mid)) {
                answer = mid;
                high = mid - 1; // try smaller time
            } else {
                low = mid + 1; // need more time
            }
        }

        return answer;
    }

    private boolean canRepair(int[] ranks, int cars, long time) {
        long repaired = 0;

        for (int rank : ranks) {
            // number of cars this mechanic can repair in given time
            repaired += Math.sqrt(time / rank);

            if (repaired >= cars) {
                return true;
            }
        }

        return false;
    }
}