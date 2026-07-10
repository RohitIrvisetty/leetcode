class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        backtrack(0, s, sb, ans);
        return ans;
    }

    private void backtrack(int index, String givenString, StringBuilder sb, List<String> ans) {

        if (index == givenString.length()) {
            ans.add(new StringBuilder(sb).toString());
            return;
        }

        backtrack(index + 1, givenString, sb, ans);

        if (!Character.isDigit(sb.charAt(index))) {
            sb.setCharAt(index, transform(sb.charAt(index)));

            backtrack(index + 1, givenString, sb, ans);

            sb.setCharAt(index, transform(sb.charAt(index)));
        }
        
    }

    private char transform(char ch) {
        if (Character.isDigit(ch)) {
            return ch;
        }

        if (Character.isUpperCase(ch)) {
            return Character.toLowerCase(ch);
        }

        return Character.toUpperCase(ch);
    }
}