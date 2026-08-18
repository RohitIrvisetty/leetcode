class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();

        int i = n1 - 1, j = n2 - 1;
        int carry = 0, sum = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {
            int digit1 = num1.charAt(i) - '0';
            int digit2 = num2.charAt(j) - '0';

            //sum += (carry + digit1 + digit2) % 10;
            sb.append(String.valueOf((carry + digit1 + digit2) % 10));

            carry = (carry + digit1 + digit2) / 10;

            i--;
            j--;
        }

        while (i >= 0) {
            int digit1 = num1.charAt(i) - '0';

            sb.append(String.valueOf((carry + digit1) % 10));

            carry = (carry + digit1) / 10;
            i--;
        }

        while (j >= 0) {
            int digit2 = num2.charAt(j) - '0';

            sb.append(String.valueOf((carry + digit2) % 10));

            carry = (carry + digit2) / 10;
            j--;
        }

        if (carry > 0) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}