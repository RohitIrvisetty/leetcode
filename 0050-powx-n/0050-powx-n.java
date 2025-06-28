class Solution {
    public double myPow(double x, int n) {
       return findPow(x, (long) n);
    }

    public double findPow(double x, long n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / findPow(x, -1 * n);
        } else if (n % 2 == 0) {
            return findPow(x * x, n / 2);
        } else {
            return x * findPow(x * x, (n - 1) / 2);
        }
    }
}