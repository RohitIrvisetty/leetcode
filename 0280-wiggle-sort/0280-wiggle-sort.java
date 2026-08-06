class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && nums[i] <= nums[i + 1]) {
                continue;
            } else if (i % 2 == 1 && nums[i] >= nums[i + 1]) {
                continue;
            }

            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int left, int right) {
        if (left != right) {
            nums[left] = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[left] ^ nums[right];
        }
    }
}