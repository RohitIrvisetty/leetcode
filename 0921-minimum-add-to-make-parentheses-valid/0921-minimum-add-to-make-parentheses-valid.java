class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() == 0 || st.peek() != '(') {
                    st.push(ch);
                } else {
                    st.pop();
                }
            }
        } 
        return st.size();
    }
}