class Solution {
    public List<String> letterCombinations(String digits) {
        String[] numberMap= new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();

        backtrack(0, "", digits, numberMap, ans);
        return ans;
    }

    private void backtrack(int index, String current, String digits, String[] numberMap, List<String> ans) {
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        String letters = numberMap[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            backtrack(index + 1, current + letters.charAt(i), digits, numberMap, ans);
        }
    }
}