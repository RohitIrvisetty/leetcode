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
    private List<List<Integer>> paths = new ArrayList<>();
    private List<Integer> currPath = new ArrayList<>();
    private int currSum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return paths;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        if (isLeafNode(root)) {
            currSum += root.val;
            currPath.add(root.val);
            
            if (currSum == targetSum) {
                System.out.println(currPath);
                paths.add(new ArrayList<>(currPath));
            }

            currSum -= root.val;
            currPath.remove(currPath.size() - 1);
        }

        currSum += root.val;
        currPath.add(root.val);

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        currSum -= root.val;
        currPath.remove(currPath.size() - 1);
    }

    private boolean isLeafNode(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}