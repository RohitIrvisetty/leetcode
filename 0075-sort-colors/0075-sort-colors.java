class Solution {
    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }


    public void sortColors(int[] nums) {
        int len = nums.length;
        int low = 0, high = len - 1;
        int mid = 0;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low , mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, high, mid);
                high--;
            }
        }
    }
}