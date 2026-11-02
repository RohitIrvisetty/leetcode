class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int currIdx = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
                i++;
            }
        }


        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums, currIdx++, i);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        if (nums[left] != nums[right]) {
            nums[left] = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[left] ^ nums[right];
        }
    }
}