class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long k = n - 1L;

        for (int bit = 0; k > 0; bit++) {
            // This bit position is available
            if ((x & (1L << bit)) == 0) {

                // Put the lowest bit of k here
                if ((k & 1L) != 0) {
                    ans |= (1L << bit);
                }

                // Move to the next bit of k
                k >>= 1;
            }
        }

        return ans;
    }
}