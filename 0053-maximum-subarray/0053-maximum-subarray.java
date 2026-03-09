class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;

        for (int num: nums) {
            sum = num + sum;
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}