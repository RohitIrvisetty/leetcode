class Solution {
    public int[] singleNumber(int[] nums) {
        int xorResult = 0, a = 0, b = 0;

        for (int i = 0; i < nums.length; i++) {
            xorResult ^= nums[i];
        }

        int diff = xorResult & (-xorResult);
        for (int i = 0; i < nums.length; i++) {
            if ((diff & nums[i]) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[] {a, b};
    }
}