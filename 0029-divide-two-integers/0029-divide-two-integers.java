class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        long num = Math.abs((long) dividend), denum = Math.abs((long) divisor);
        long ans = 0;

        if ((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)) {
            sign = -1;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == divisor) return 1;
        if (divisor == 1) return dividend;

        while (num >= denum) {

            long multiple = 1, temp = denum;
            while (num >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            num -= temp;
            ans += multiple;
        }
        
        if (ans > Integer.MAX_VALUE)
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        
        return sign > 0? (int) ans: -1 * (int) ans;
        
    }
}