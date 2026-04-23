class Solution {
    public String largestGoodInteger(String num) {
        int maxInt = Integer.MIN_VALUE;
        int repetitionCount = 1;

        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1)) {
                repetitionCount++;
            } else {
                repetitionCount = 1;
            }

            if (repetitionCount == 3) {
                System.out.println(Integer.parseInt(num.substring(i - 3 + 1, i + 1)));
                maxInt = Math.max(maxInt, Integer.parseInt(num.substring(i - 3 + 1, i + 1)));
            }

        }

        if (maxInt == 0) {
            return new String(new char[] {48, 48, 48});
        }

        if (maxInt > 0) {
            return String.valueOf(maxInt);
        }

        return "";
    }
}



