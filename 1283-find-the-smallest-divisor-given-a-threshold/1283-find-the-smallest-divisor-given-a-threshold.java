class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = getMax(nums);

        while (left < right) {
            int mid = left + (right - left) / 2;

            long sum = calculateDivisorSum(nums, mid);
            if (sum <= threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            min = Math.min(num, min);
        }

        return min;
    }

    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            max = Math.max(num, max);
        }

        return max;
    }

    private long calculateDivisorSum(int[] nums, int div) {
        long sum = 0;
        for (int num: nums) {
            sum += (num + div - 1) / div;
        }
        return sum;
    }
}