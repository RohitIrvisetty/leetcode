/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 1, ans);
        return ans;
    }

    private void dfs(TreeNode node, int depth, List<Integer> ans) {
        if (node == null) {
            return;
        }

        if (depth > ans.size()) {
            ans.add(node.val);
        } else {
            int currStoredVal = ans.get(depth - 1);

            if (currStoredVal < node.val) {
                ans.set(depth - 1, node.val);
            }
        }

        dfs(node.left, depth + 1, ans);
        dfs(node.right, depth + 1, ans);
    }
}