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
    private int count = 0;
    private Map<Long, Integer> prefixCount = new HashMap<>();
    private long currSum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        prefixCount.put(0L, 1);        
        dfs(root, targetSum);
        return count;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        currSum += root.val;
        count += prefixCount.getOrDefault(currSum - targetSum, 0);

        prefixCount.put(
            currSum,
            prefixCount.getOrDefault(currSum, 0) + 1
        );
        
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        prefixCount.put(currSum, prefixCount.get(currSum) - 1);
        currSum -= root.val;
    }
}