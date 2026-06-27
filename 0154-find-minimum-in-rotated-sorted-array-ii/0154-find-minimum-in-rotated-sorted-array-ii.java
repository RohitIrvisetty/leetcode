class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int prev = nums[0];

        for (int i = 1; i < n; i++) {
            if (prev > nums[i]) {
                return nums[i];
            }
        }
        
        return nums[0];
    }
}