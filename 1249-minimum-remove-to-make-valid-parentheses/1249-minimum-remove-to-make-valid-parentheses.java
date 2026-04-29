class Pair {
    Integer index;
    Character bracket;

    Pair (Integer i, Character ch) {
        index = i;
        bracket = ch;
    }

    public int getIndex() {
        return index;
    }

    public char getBracket() {
        return bracket;
    }
}

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair> st = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(new Pair(i, '('));
            } 
            else if (s.charAt(i) == ')') {
                if (st.size() > 0 && st.peek().getBracket() == '(') {
                    st.pop();
                } else {
                    st.push(new Pair(i, ')'));
                }
            }
        }
        
        if (st.size() == 0) return s;
        StringBuilder ans = new StringBuilder();
        int indexToRemove = st.peek().getIndex();
        
        for (int i = n - 1; i >= 0; i--) {
            if (i == indexToRemove && st.size() != 0) {
                st.pop();
                
                if (st.size() != 0) {
                    indexToRemove = st.peek().getIndex();
                }
                continue;
            }
            ans.append(s.charAt(i));
        }

        return ans.reverse().toString(); 
    }
}