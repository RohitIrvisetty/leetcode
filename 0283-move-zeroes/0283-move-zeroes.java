class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int right = n - 1;
        int currentIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[currentIdx++] = nums[i];
            } 
        }

        for (int i = currentIdx; i < n; i++) {

            nums[i] = 0;
        }
    }
}