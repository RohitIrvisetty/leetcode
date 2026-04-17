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
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                result.add(curr.val);
                stack.push(curr);
                curr = curr.right;
            }

            curr = stack.pop();
            curr = curr.left;
        }      
        
        int left = 0, right = result.size() - 1;

        while (left < right) {
            swap(result, left, right);
            left++;
            right--;
        }

        return result;
    }

    private void swap(List<Integer> nums, int left, int right) {
        if (left == right) return;

        nums.set(left, nums.get(left) ^ nums.get(right));
        nums.set(right, nums.get(left) ^ nums.get(right));
        nums.set(left, nums.get(left) ^ nums.get(right));
    }
}