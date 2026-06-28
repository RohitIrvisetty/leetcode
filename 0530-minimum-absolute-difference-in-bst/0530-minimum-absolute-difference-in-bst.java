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
    class nodeInfo {
        int predVal;
        int minGap;
    }

    public int getMinimumDifference(TreeNode root) {
        nodeInfo pred = new nodeInfo();
        pred.predVal = -1;
        pred.minGap = Integer.MAX_VALUE;
        dfs(root, pred);
        return pred.minGap;
    }

    private void dfs(TreeNode node, nodeInfo pred) {
        if (node == null) {
            return;
        }

        dfs(node.left, pred);

        if (pred.predVal != -1 && node.val - pred.predVal < pred.minGap) {
            pred.minGap = node.val - pred.predVal;
        }

        pred.predVal = node.val;
        dfs(node.right, pred);
    }
}