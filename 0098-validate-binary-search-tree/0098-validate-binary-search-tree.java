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
    class State {
        TreeNode prev;
    }

    public boolean isValidBST(TreeNode root) {
        State state = new State();
        return dfs(root, state);
        
    }

    private boolean dfs(TreeNode root, State state) {
        if (root == null) {
            return true;
        }

        if (!dfs(root.left, state)) {
            return false;
        }

        if ((state.prev != null) && (state.prev.val >= root.val)) {
            return false;
        }

        state.prev = root;

        if (!dfs(root.right, state)) {
            return false;
        }

        return true;
    }
}