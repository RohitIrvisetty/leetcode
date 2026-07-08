class Solution {
    public int pivotIndex(int[] nums) {
        // Calculate total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Check each index as a possible pivot
        for (int i = 0; i < nums.length; i++) {
            // Right sum excludes the current element
            int rightSum = totalSum - leftSum - nums[i];

            // Found pivot index
            if (leftSum == rightSum) {
                return i;
            }

            // Add current element to left sum for next iteration
            leftSum += nums[i];
        }

        // No pivot index exists
        return -1;
    }
}