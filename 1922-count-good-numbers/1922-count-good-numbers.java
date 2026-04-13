class Solution {

    static final long mod = 1000000007;

    public int countGoodNumbers(long n) {
        return (int) ((quickmul(5, (n + 1) / 2) * quickmul(4, n / 2)) % mod);
    }

    // use fast exponentiation to calculate x^y % mod
    public long quickmul(long base, long exp) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}