class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        StringBuilder firstNumber = new StringBuilder(num1);
        StringBuilder secondNumber = new StringBuilder(num2);

        firstNumber.reverse();
        secondNumber.reverse();

        int N = firstNumber.length() + secondNumber.length();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            answer.append(0);
        }

        for (int place2 = 0; place2 < secondNumber.length(); place2++) {
            int digit2 = secondNumber.charAt(place2) - '0';

            for (int place1 = 0; place1 < firstNumber.length(); place1++) {
                int digit1 = firstNumber.charAt(place1) - '0';

                int currentPos = place1 + place2;

                int carry = answer.charAt(currentPos) - '0';
                int multiplication = digit1 * digit2 + carry;

                answer.setCharAt(
                    currentPos,
                    (char) ((multiplication % 10) + '0')
                );

                // Carry the tens place of the multiplication result by
                // adding it to the next position in the answer array.
                int value = (answer.charAt(currentPos + 1) - '0') + multiplication / 10;
                answer.setCharAt(currentPos + 1, (char) (value + '0'));
            }
        }

        // Pop excess 0 from the rear of answer.
        while (answer.charAt(answer.length() - 1) == '0') {
            answer.setLength(answer.length() - 1);
        }

        answer.reverse();
        return answer.toString();
    }
}