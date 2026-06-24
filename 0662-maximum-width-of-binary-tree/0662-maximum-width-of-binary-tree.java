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
    private record pair(TreeNode root, int val) {}

    public int widthOfBinaryTree(TreeNode root) {
        
        LinkedList<pair> list = new LinkedList<>();
        list.offer(new pair(root, 1));
      
        int maxWidth = 0;
      
        while (!list.isEmpty()) {
            
            int currentLevelWidth = list.peekLast().val() - list.peekFirst().val() + 1;
            maxWidth = Math.max(maxWidth, currentLevelWidth);
          
            int levelSize = list.size();
            for (int i = 0; i < levelSize; i++) {
                pair currentPair = list.poll();
                TreeNode currentNode = currentPair.root();
                int currentPosition = currentPair.val();
              
                if (currentNode.left != null) {
                    list.offer(new pair(currentNode.left, currentPosition * 2));
                }
              
                if (currentNode.right != null) {
                    list.offer(new pair(currentNode.right, currentPosition * 2 + 1));
                }
            }
        }
      
        return maxWidth;
    }
}