class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                return index + 1;
            }
        }

        // for (int i = 0; i < n; i++) {
        //     if (nums[i] > 0) {
        //         return i + 1;
        //     }
        // }
        return 1;
    }
}