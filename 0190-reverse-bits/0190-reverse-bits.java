class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            n = n >> 1;
            bit = bit << (31 - i);
            ans = ans | bit;
        }
        return ans;
    }
}