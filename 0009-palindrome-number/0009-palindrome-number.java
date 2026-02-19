class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int revNum = 0;
        int dummy = x;
        while (dummy > 0) {
            int digit = dummy % 10;

            revNum = (revNum * 10) + digit;
            dummy = dummy / 10;
        }
        return revNum == x;
    }
}