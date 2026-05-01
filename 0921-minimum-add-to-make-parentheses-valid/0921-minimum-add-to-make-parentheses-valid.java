class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0; // unmatched '('
        int insertions = 0; // insertions needed

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else { // ')'
                open--; // match

                if (open < 0) {
                    insertions++; // need to insert '('
                    open = 0;
                }
            }
        }

        return insertions + open;
    }
}