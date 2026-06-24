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
    private StringBuilder currentNum = new StringBuilder();

    public int sumNumbers(TreeNode root) {

        traverseTree(root);

        return sum;
    } 

    private void traverseTree(TreeNode node) {
        if (isLeafNode(node)) {
            currentNum.append(String.valueOf(node.val));
            sum += Integer.parseInt(currentNum.toString());
            currentNum.setLength(currentNum.length() - 1);
            return;
        }

        currentNum.append(String.valueOf(node.val));

        if (node.left != null) {
            traverseTree(node.left);
        }

        if (node.right != null) {
            traverseTree(node.right);
        }

        currentNum.setLength(currentNum.length() - 1);
    }

    private boolean isLeafNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }

        return false;
    }
}