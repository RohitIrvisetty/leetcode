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
    class nodeContainer {
        TreeNode first;
        TreeNode middle;
        TreeNode last;
        TreeNode prev;
    }

    public void recoverTree(TreeNode root) {
        nodeContainer nodes = new nodeContainer();

        dfs(root, nodes);

        if (nodes.first != null && nodes.last != null) {
            swapValues(nodes.first, nodes.last); 
        } else {
            swapValues(nodes.first, nodes.middle);
        }
    }

    private void dfs(TreeNode root, nodeContainer nodes) {
        if (root == null) {
            return;
        }

        dfs(root.left, nodes);

        if (nodes.prev != null && nodes.prev.val > root.val) {
            if (nodes.first == null) {
                nodes.first = nodes.prev;
                nodes.middle = root;
            } else {
                nodes.last = root;
            }
        }
        nodes.prev = root;
        dfs(root.right, nodes);
    }

    private void swapValues(TreeNode A, TreeNode B) {
        if (A.val == B.val){
            return;
        }

        A.val = A.val ^ B.val;
        B.val = A.val ^ B.val;
        A.val = A.val ^ B.val;
    }
}