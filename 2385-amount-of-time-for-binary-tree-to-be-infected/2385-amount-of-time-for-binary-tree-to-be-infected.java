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
    class Time {
        int maxTime = 0;
    }
    public int amountOfTime(TreeNode root, int start) {
        Time time = new Time();
        dfs(root, start, time);
        return time.maxTime;
    }

    private int dfs(TreeNode node, int start, Time time) {
        if (node == null) {
            return -1;
        }

        if (node.val == start) {
            time.maxTime = Math.max(maxDepth(node) - 1, time.maxTime);
            return 1;
        }

        int left = dfs(node.left, start, time);

        if (left != -1) {
            time.maxTime = Math.max(maxDepth(node.right) + left, time.maxTime);
            return left + 1;
        }

        int right = dfs(node.right, start, time);

        if (right != -1) {
            time.maxTime = Math.max(maxDepth(node.left) + right, time.maxTime);
            return 1 + right;
        }

        return -1;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return 1 + Math.max(left, right);
    }
}