class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Integer> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k > 0 && ((num.charAt(i) - '0') < st.peek())) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i) - '0');
        }

        for (int i = 0; i < k; i++) {
            st.pop();
        }

        if (st.isEmpty()) {
            return "0";
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        StringBuilder ans = new StringBuilder(sb).reverse();
        int i = 0;
        for (i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) != '0') {
                break;
            }
        }

        // String result = ans.substring(i);
        return ans.substring(i).isEmpty() ? "0": ans.substring(i);
    }
}