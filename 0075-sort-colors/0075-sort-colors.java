class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        while(mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low += 1;
                mid += 1;
            } else if (nums[mid] == 1) {
                mid += 1;
            } else {
                swap(nums, mid, high);
                high -= 1;
            }
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        if (left == right) return;

        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];
    }
}