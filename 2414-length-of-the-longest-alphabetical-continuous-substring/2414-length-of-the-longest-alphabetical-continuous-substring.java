class Solution {
    public int longestContinuousSubstring(String s) {
        int maxLen = 1, currSubString = 0;
        char prevChar = '\0';

        for (char ch: s.toCharArray()) {
            if (ch - 'a' - prevChar + 'a' == 1) {
                currSubString++;
                maxLen = Math.max(maxLen, currSubString);
                prevChar = ch;
            } else {
                currSubString = 1;
                prevChar = ch;
            }
        }
        return maxLen;
    }
}