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
    public TreeNode reverseOddLevels(TreeNode root) {
        int depth = 0;
        dfs(root.left, root.right, depth);
        return root;
    } 

    private void dfs(TreeNode leftChild, TreeNode rightChild, int depth) {
        if (leftChild == null || rightChild == null) {
            return;
        }

        if (depth % 2 == 0 && leftChild != null) {
            int temp = leftChild.val;
            leftChild.val = rightChild.val;
            rightChild.val = temp;
        }

        dfs(leftChild.left, rightChild.right, depth + 1);
        dfs(leftChild.right, rightChild.left, depth + 1);
    }
}