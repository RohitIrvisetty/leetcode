class Solution {
    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        int i = -1;

        for (int j = 0; j < len; j++) {
            if (nums[j] % 2 == 0) {
                i++;
                swap(nums, i ,j);
            }
        }
        return nums;
    }
}