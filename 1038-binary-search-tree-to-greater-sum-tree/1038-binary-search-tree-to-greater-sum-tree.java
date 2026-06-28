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
    private int predSum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode rightNode = bstToGst(root.right);
        root.val += predSum;
        predSum = root.val;

        if (root.left != null) {
            bstToGst(root.left);
        }
        return root;
    }
}