class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count1 = 0;
            for (int j = 0; j < nums.length; j++) {
                count1 += (nums[j] >> i) & 1;
            }
            ans += count1 * (nums.length - count1);
        }
        return ans;
    }
}