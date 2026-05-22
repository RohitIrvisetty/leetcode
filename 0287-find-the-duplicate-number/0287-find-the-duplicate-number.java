class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0, n = nums.length;

        while (i < n) {
            int correctIndex = nums[i] - 1;

            if (nums[i] <= n && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(nums));
        for (int j = 1; j <= n; j++) {
            if (j != nums[j - 1]) {
                return nums[j - 1];
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