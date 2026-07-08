class Solution {
    public int findMiddleIndex(int[] nums) {
        // Calculate total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Check each index
        for (int i = 0; i < nums.length; i++) {
            // Sum of elements on the right side
            int rightSum = totalSum - leftSum - nums[i];

            // If left and right sums are equal, this is the middle index
            if (leftSum == rightSum) {
                return i;
            }

            // Add current element to left sum for next iteration
            leftSum += nums[i];
        }

        // No middle index found
        return -1;
    }
}