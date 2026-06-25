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
    private StringBuilder path = new StringBuilder();
    private String ans = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root);
        return ans.toString();    
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        
        path.append((char) ('a' + root.val));

        if (isLeafNode(root)) {
            String curr = new StringBuilder(path).reverse().toString();
            
            if (ans == null || curr.compareTo(ans) < 0) {
                ans = curr;
            }

            path.setLength(path.length() - 1);

            return;
        }

        dfs(root.left);
        dfs(root.right);

        path.setLength(path.length() - 1);
    }

    private boolean isLeafNode(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}