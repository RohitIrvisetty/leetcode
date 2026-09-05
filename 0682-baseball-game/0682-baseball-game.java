class Solution {
    public int calPoints(String[] operations) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            if (isOperator(operations[i])) {
                if (operations[i].equals("+")) {
                    int top1 = st.pop();
                    int top2 = st.pop();
                    st.push(top2);
                    st.push(top1);
                    st.push(top1 + top2);
                } else if (operations[i].equals("D")) {
                    int top = st.peek();
                    st.push(2 * top);
                } else {
                    st.pop();
                }
            } else {
                st.push(Integer.parseInt(operations[i]));
            }
        }

        while (!st.isEmpty()) {
            ans += st.pop();
        }
        
        return ans;
    }

    private boolean isOperator(String operation) {
        if (operation.equals("C") || operation.equals("D") || operation.equals("+")) {
            return true;
        }
        return false;
    }
}