class Solution {
    public int arrangeCoins(int n) {
        long left = 0, right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long curr = apSum(mid);

            if (curr == n) {
                return (int) mid;
            } else if (curr > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }

    private long apSum(long mid) {
        return (long) (mid * (mid + 1) / 2);
    }
}