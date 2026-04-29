class Solution {
    public int minInsertions(String s) {
    int need = 0;        // number of ')' needed
    int insertions = 0;

    for (char c : s.toCharArray()) {
        if (c == '(') {
            need += 2;

            if (need % 2 == 1) { // make it even
                insertions++;
                need--;
            }
        } else { // c == ')'
            need--;

            if (need < 0) {
                insertions++; // insert '('
                need += 2;     // now we need one more ')'
            }
        }
    }

    return insertions + need;
}
}