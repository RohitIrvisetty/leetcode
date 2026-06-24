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
    private List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> currPath = new ArrayList();
        dfs(root, currPath);
        return paths;
    }

    private void dfs(TreeNode root, List<String> currPath) {
        if (root == null) {
            return;
        }

        currPath.add(String.valueOf(root.val));

        if (isLeafNode(root)) {
            paths.add(String.join("->", currPath));
            currPath.remove(currPath.size() - 1);
            return;
        }

        dfs(root.left, currPath);
        dfs(root.right, currPath);

        currPath.remove(currPath.size() - 1);
    }

    private boolean isLeafNode(TreeNode root) {
        if (root.right == null && root.left == null) {
            return true;
        }
        return false;
    }
}