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
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null && isLeaf(root.left)) {
            sum += root.left.val;
        }

        dfs(root.left);
        dfs(root.right);
    }

    private boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}