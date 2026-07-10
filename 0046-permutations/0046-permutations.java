class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] inUse = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        backtrack(nums, inUse, current, ans);
        return ans;
    }

    private void backtrack(int[] nums, boolean[] inUse, List<Integer> current, List<List<Integer>> ans) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (inUse[i]) {
                continue;
            }

            current.add(nums[i]);
            inUse[i] = true;
            backtrack(nums, inUse, current, ans);

            current.remove(current.size() - 1);
            inUse[i] = false;
        }
    }
}