class Solution {
    public int minOperations(String[] logs) {
        int n = logs.length;
        Deque<String> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (logs[i].equals("../")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (logs[i].equals("./")) {
                continue;
            } else {
                st.push(logs[i]);
            }
        }
        return st.size();
    }
}