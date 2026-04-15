class Solution {
    public int reverse(int x) {
        int revNum = 0;
        int dummy = x;

        while (dummy != 0) {
            int digit = dummy % 10;

            if ((revNum > Integer.MAX_VALUE / 10) || (revNum == Integer.MAX_VALUE && digit > 7)) {
                return 0;
            }

            if ((revNum < Integer.MIN_VALUE / 10) || (revNum == Integer.MIN_VALUE && digit < -8)) {
                return 0;
            }

            revNum = (revNum * 10) + digit;
            dummy = dummy / 10;
        }
        return revNum;
    }
}