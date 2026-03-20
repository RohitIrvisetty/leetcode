class Solution {
    public int sumBase(int n, int k) {
        int sum = 0;

        while (n > 0) {
            int remainder = trailingDigit(n, k);
            sum += remainder;
            n = n / k;
        }

        return sum;
    }

    private int trailingDigit(int n, int k) {
        return n % k;
    }
}