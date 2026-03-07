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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean left2Right = true;

        if (root == null) return result;
        while(queue.size() != 0) {
            List<Integer> level = new ArrayList<>();
            int queueLength = queue.size();

            for (int i = 0; i < queueLength; i++) {
                TreeNode node = queue.poll();

                level.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (!left2Right) {
                Collections.reverse(level);
            }
            left2Right = !left2Right;
            result.add(level);
        }

        return result;
    }
}