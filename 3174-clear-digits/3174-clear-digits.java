public class Solution {

    public String clearDigits(String s) {
        int answerLength = 0;
        char[] charArray = s.toCharArray();

        for (int charIndex = 0; charIndex < s.length(); charIndex++) {
            if (Character.isDigit(s.charAt(charIndex))) {
                answerLength--;
            } else {
                charArray[answerLength++] = s.charAt(charIndex);
            }
        }

        return new String(charArray, 0, answerLength);
    }
}