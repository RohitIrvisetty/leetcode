class Solution {
    public boolean check(int[] nums) {
        int trough = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > nums[(i + 1) % length]) {
                trough++;
            }
        }
        return trough <= 1;
    }
}