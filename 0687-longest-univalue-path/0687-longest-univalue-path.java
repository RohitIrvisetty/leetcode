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
    private int maxLen = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxLen;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftLen = 0, rightLen = 0;
        if (root.left != null && root.left.val == root.val) {
            leftLen = left + 1;
        }

        if (root.right != null && root.right.val == root.val) {
            rightLen = right + 1;
        }
        maxLen = Math.max(maxLen, rightLen + leftLen);

        return Math.max(rightLen, leftLen);
    }
}