class Solution {
    private void swap(int[] nums, int left, int right) {
        if (left == right) return;
        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];
    } 
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int currentIdx = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] != 0) {
                swap(nums, currentIdx++, right);
            } 
        }

        

    }
}