class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(1, n, k, current, ans);
        return ans;
    }

    private void backtrack(int index, int n, int k, List<Integer> curr, List<List<Integer>> ans) {
        if (curr.size() == k) {
            ans.add(new ArrayList(curr));
            return;
        }

        for (int i = index; i <= n; i++) {
            // System.out.println()
            curr.add(i);
            backtrack(i + 1, n, k, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}