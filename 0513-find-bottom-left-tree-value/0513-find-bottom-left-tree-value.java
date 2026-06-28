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
        int val;
        int depth;
    }
    public int findBottomLeftValue(TreeNode root) {
        nodeInfo leftMostNode = new nodeInfo();
        dfs(root, 0, leftMostNode);
        return leftMostNode.val;
    }

    private void dfs(TreeNode node, int depth, nodeInfo leftMostNode) {
        if (node == null) {
            return;
        }

        if (leftMostNode.depth <= depth) {
            leftMostNode.val = node.val;
            leftMostNode.depth = depth;
        }

        dfs(node.right, depth + 1, leftMostNode);
        dfs(node.left, depth + 1, leftMostNode);
    }
}