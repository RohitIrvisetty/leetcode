class Solution {
    public int[] singleNumber(int[] nums) {
        int xorResult = 0;
        
        for (int i = 0; i < nums.length; i++) {
            xorResult ^= nums[i];
        }

        int diff = xorResult & -xorResult;

        int a = 0;
        int b = 0;

        for (int num: nums) {
            if ((num & diff) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }
}