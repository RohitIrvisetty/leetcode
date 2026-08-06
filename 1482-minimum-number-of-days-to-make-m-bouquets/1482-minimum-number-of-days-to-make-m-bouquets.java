class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long left = 1, right = getMax(bloomDay);

        if ((long) m * (long) k > bloomDay.length) {
            return -1;
        }

        while (left < right) {
            long mid = left + (right - left) / 2;

            int possibleBoquets = calculateBouquets(bloomDay, mid, k);

            if (possibleBoquets >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private long getMax(int[] bloomDay) {
        int n = bloomDay.length;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (bloomDay[i] > maxi) {
                maxi = bloomDay[i];
            }
        }
        return (long) maxi;
    }

    private int calculateBouquets(int[] bloomDays, long mid, int k) {
        int n = bloomDays.length;
        int count = 0, currLen = 0;

        for (int i = 0; i < n; i++) {
            if (bloomDays[i] <= mid) {
                currLen++;
            } else {
                currLen = 0;
            }

            if (currLen == k) {
                count++;
                currLen = 0;
            }
        }
        return count;
    }
}