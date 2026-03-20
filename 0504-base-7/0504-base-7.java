class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder output = new StringBuilder();
        boolean isNegative = num < 0;
        num = Math.abs(num);
        char[] base7 = "0123456".toCharArray();
        while (num != 0) {
            output.append(num % 7);
            num = num / 7;
        }

        if (isNegative) {
            output.append("-");
        }
        return output.reverse().toString();
    }
}