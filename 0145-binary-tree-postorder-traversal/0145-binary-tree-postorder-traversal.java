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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {
            if (curr.right == null) {
                ans.add(curr.val);
                curr = curr.left;
            } else {
                TreeNode pred = curr.right;

                while (pred.left != null && pred.left != curr) {
                    pred = pred.left;
                }

                if (pred.left == null) {
                    pred.left = curr;
                    ans.add(curr.val);
                    curr = curr.right;
                } else {
                    pred.left = null;
                    curr = curr.left;
                }
            }
        }
        return ans.reversed();
    }
}