class Solution {
    // Method to convert a string to an integer
    public int myAtoi(String input) {
        input = input.trim();

        int i = 0, n = input.length();
        
        // Step 2: Determine the sign
        int sign = 1;
        if (i < n && input.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && input.charAt(i) == '+') {
            i++;
        }

        int result = 0;
        
        while (i < n && Character.isDigit(input.charAt(i))) {
            int digit = input.charAt(i) - '0';
            
            // 4. Check overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;
    }
}
