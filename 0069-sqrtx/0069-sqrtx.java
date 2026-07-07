class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 0, right = x / 2;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            long mid2 = (long) mid * (long) mid;

            if (mid2 == (long) x) {
                return mid;
            } else if (mid2 > (long) x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}