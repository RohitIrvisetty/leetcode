class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String[] parenthesesChoices = new String[]{"(", ")"};
        backtrack("", 0, 0, n, parenthesesChoices, ans);
        return ans;
    }

    private void backtrack(String s, int open, int close, int n, String[] parenthesesChoices, List<String> ans) {

        if (open + close == 2 * n) {
            ans.add(s);
            return;
        }

        for (int choice = 0; choice < parenthesesChoices.length; choice++) {
            if (parenthesesChoices[choice] == "(" && open < n) {
                backtrack(s + parenthesesChoices[choice], open + 1, close, n, parenthesesChoices, ans);
            } else if (parenthesesChoices[choice] == ")" && close < open){
                backtrack(s + parenthesesChoices[choice], open, close + 1, n, parenthesesChoices, ans);
            }
        }
    }
}