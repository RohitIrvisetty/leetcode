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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            insertIntoBST(root, preorder[i]);
        }

        return root;
    }

    private void insertIntoBST(TreeNode root, int ele) {
        while (true) {
            if (root.val > ele) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root.left = new TreeNode(ele);
                    return;
                }
            } else {
                if (root.right != null) {
                    root = root.right;
                } else {
                    root.right = new TreeNode(ele);
                    return;
                }
            }
        }
    }
}