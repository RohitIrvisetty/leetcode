class Solution {
    public String largestGoodInteger(String num) {
        char maxChar = '\0';
        int repetitionCount = 1;

        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1)) {
                repetitionCount++;
            } else {
                repetitionCount = 1;
            }

            if (repetitionCount == 3) {
                maxChar = (char) Math.max(maxChar, (char) num.charAt(i - 1));
            }

        }

        return maxChar == '\0'? "": new String(new char[] {maxChar, maxChar, maxChar});
    }
}



