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
        int count;
        TreeNode node;
        int mode;
    }

    public int[] findMode(TreeNode root) {
        State state = new State();
        List<Integer> modes = new ArrayList<>();
        dfs(root, state, modes);
        return modes.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(TreeNode root, State state, List<Integer> modes) {
        if (root == null) {
            return;
        }

        dfs(root.left, state, modes);

        if (state.node == null || state.node.val != root.val) {
            
            if (state.node == null || state.mode == 1) {
                modes.add(root.val);
                state.mode = 1;
            }

            state.count = 1;
            state.node = root;
        } else {
            state.count++;

            if (state.count > state.mode) {
                state.mode = state.count;
                modes.clear();
                modes.add(root.val);
            } else if (state.count == state.mode) {
                modes.add(root.val);
            }
            
        }

        dfs(root.right, state, modes);
    }
}