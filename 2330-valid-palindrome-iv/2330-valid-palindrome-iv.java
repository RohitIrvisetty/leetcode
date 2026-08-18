class Solution {
    public boolean makePalindrome(String s) {
        int left = 0, right = s.length() - 1;
        int miss = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                miss++;
                if (miss > 2) {
                    return false;
                }
            } 
            left++;
            right--;
        }
        return true;
    }
}