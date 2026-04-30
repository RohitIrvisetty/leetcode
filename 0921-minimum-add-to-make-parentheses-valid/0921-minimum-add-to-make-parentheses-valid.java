class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0; // unmatched '('
        int insertions = 0; // insertions needed

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else { // ')'
                if (open > 0) {
                    open--; // match
                } else {
                    insertions++; // need to insert '('
                }
            }
        }

        return insertions + open;
    }
}