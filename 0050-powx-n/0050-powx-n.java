class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            return 1 / power(x, -N);
        }
        return power(x, N);
    }

    private double power(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n % 2 == 0) {
            return power(x * x, n / 2);
        } else {
            return x * power(x, n - 1);
        }
    }
}