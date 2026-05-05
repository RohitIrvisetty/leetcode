class Solution {
    public int maxPower(String s) {
        char prevChar = ' ';
        int maxLen = 0, repChar = 0;

        for (char ch: s.toCharArray()) {
            if (ch == prevChar) {
                repChar++;
                maxLen = Math.max(maxLen, repChar);
            } else {
                repChar = 1;
                prevChar = ch;
            }
        }

        return maxLen == 0? 1: maxLen;
    }
}