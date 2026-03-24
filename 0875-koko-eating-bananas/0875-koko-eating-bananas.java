class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;

            int reqTime = calculateHours(piles, mid);
            
            if (reqTime <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile: piles) {
            if (pile > max) {
                max = pile;
            }
        }
        return max;
    }

    private int calculateHours(int[] piles, int mid) {
        int hours = 0;

        for (int pile: piles) {
            hours += (pile + mid - 1) / mid;
        }

        return hours;
    }
}