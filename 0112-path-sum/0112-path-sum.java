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
    private int currSum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (isLeafNode(root)) {
            currSum += root.val;

            if (currSum == targetSum) {
                return true;
            }

            currSum -= root.val;

            return false;
        }

        currSum += root.val;

        boolean left = hasPathSum(root.left, targetSum);
        boolean right = hasPathSum(root.right, targetSum);

        currSum -= root.val;
        return left || right;
            
    }

    private boolean isLeafNode(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}