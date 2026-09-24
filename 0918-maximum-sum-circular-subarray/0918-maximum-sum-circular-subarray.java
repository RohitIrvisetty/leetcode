class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        
        int currMax = 0, currMin = 0;
        int globalMax = Integer.MIN_VALUE, globalMin = Integer.MAX_VALUE;
        int total = 0;

        for (int i = 0; i < n; i++) {
            currMin = Math.min(nums[i], currMin + nums[i]);
            currMax = Math.max(nums[i], currMax + nums[i]);

            globalMin = Math.min(globalMin, currMin);
            globalMax = Math.max(globalMax, currMax);
            total += nums[i];
        }

        if (globalMax <= 0) {
            return globalMax;
        }

        return Math.max(globalMax, total - globalMin);
    }
}