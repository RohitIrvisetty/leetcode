class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }

        int left = 0, right = num / 2;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            long mid2 = (long) mid * (long) mid;

            if (mid2 == (long) num) {
                return true;
            } else if (mid2 > (long) num) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return false;
    }
}