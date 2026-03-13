class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int evenIdx = 0;
        int oddIdx = 1;
        int n = nums.length;

        while (evenIdx < n && oddIdx < n) {
            
            while (evenIdx < n && (nums[evenIdx] % 2 == 0))
                evenIdx += 2;

            while (oddIdx < n && (nums[oddIdx] % 2 != 0))
                oddIdx += 2;
            
            if (evenIdx < n && oddIdx < n) {
                swap(nums, evenIdx, oddIdx);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j)
            return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}