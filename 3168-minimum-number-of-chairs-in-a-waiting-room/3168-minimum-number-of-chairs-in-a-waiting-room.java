class Solution {
    public int minimumChairs(String s) {
        int maxLen = 1, chair = 0;
        char prevChar = ' '; 

        for (char ch: s.toCharArray()) {
            if (ch == 'E') {
                chair++;
                maxLen = Math.max(maxLen, chair);
            } else {
                chair--;
            }
        }
        return maxLen;
    }
}