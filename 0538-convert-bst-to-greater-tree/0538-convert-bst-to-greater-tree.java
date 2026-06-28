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
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode rightNode = convertBST(root.right);
        

        System.out.println(root.val + " " + predSum);
        root.val += predSum;

        predSum = root.val;
        System.out.println(root.val + " " + predSum);

        if (root.left != null) {
            convertBST(root.left);
        }
        return root;
    }
}