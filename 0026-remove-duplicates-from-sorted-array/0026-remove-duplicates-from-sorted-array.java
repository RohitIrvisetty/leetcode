class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int divider = 0;
        int pivot = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] != pivot && nums[i] > pivot) {
                divider++;
                swap(nums, divider, i);
                pivot = nums[divider];
            }
        }

        return divider + 1;
    }

    private void swap(int[] nums, int left, int right) {
        if (left == right) return;

        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];
    }
}