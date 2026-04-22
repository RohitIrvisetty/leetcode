class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, n = nums.length;

        while (i < n) {
            int correctIndex = nums[i];

            if (nums[i] < n && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (j != nums[j]) {
                return j;
            }
        }

        return n;
    }

    private void swap(int[] nums, int left, int right) {
        if (left == right) return;

        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];
    }
}