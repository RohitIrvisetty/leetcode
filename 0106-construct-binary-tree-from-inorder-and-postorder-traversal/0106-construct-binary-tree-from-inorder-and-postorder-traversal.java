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
    private Map<Integer, Integer> inMap = new HashMap<>();
    private int[] postorderArray;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorderArray = postorder;

        for (int i = 0; i < inorder.length; i++) {
            inMap.putIfAbsent(inorder[i], i);
        }

        return dfs(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode dfs(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }

        int rootValue = this.postorderArray[postorderEnd];

        TreeNode root = new TreeNode(rootValue);

        int rootInorderindex = this.inMap.get(rootValue);

        int leftSubArraySize = rootInorderindex - inorderStart;

        root.left = dfs(inorderStart, rootInorderindex - 1, postorderStart, postorderStart + leftSubArraySize - 1);

        root.right = dfs(rootInorderindex + 1, inorderEnd, postorderStart + leftSubArraySize, postorderEnd - 1);

        return root;
    }
}