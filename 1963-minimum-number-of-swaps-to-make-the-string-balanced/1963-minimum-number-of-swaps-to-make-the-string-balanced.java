class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int maxImbalance = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                balance++;
            } else {
                balance--;
                if (balance < 0) {
                    maxImbalance = Math.min(maxImbalance, balance);
                }
            }

        }

        return (-1 * maxImbalance + 1) / 2;
    }
}