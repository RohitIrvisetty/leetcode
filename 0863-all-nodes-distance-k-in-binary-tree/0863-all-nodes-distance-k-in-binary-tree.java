/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, target, k, ans);
        return ans;
    }

    private int dfs(TreeNode node, TreeNode target, int k, List<Integer> ans) {
        if (node == null) {
            return -1;
        }

        if (node == target) {
            collect(node, k, ans);
            return 0;
        }

        int left = dfs(node.left, target, k, ans);
        if (left != -1) {
            if (1 + left == k) {
                ans.add(node.val);
            } else {
                collect(node.right, k - 2 - left, ans);
            }
            return 1 + left;
        }

        int right = dfs(node.right, target, k, ans);
        if (right != -1) {
            if (1 + right == k) {
                ans.add(node.val);
            } else {
                collect(node.left, k - 2 - right, ans);
            }
            return 1 + right;
        }
        return -1;
    }

    private void collect(TreeNode node, int k, List<Integer> ans) {
        if (node == null) {
            return;
        }

        if (k == 0) {
            ans.add(node.val);
        }

        collect(node.left, k - 1, ans);
        collect(node.right, k - 1, ans);
    }
}