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
    public int widthOfBinaryTree(TreeNode root) {
        
        LinkedList<Pair<TreeNode, Integer>> list = new LinkedList<>();
        list.offer(new Pair<>(root, 1));
      
        int maxWidth = 0;
      
        while (!list.isEmpty()) {
            
            int currentLevelWidth = list.peekLast().getValue() - list.peekFirst().getValue() + 1;
            maxWidth = Math.max(maxWidth, currentLevelWidth);
          
            int levelSize = list.size();
            for (int i = 0; i < levelSize; i++) {
                Pair<TreeNode, Integer> currentPair = list.poll();
                TreeNode currentNode = currentPair.getKey();
                int currentPosition = currentPair.getValue();
              
                if (currentNode.left != null) {
                    list.offer(new Pair<>(currentNode.left, currentPosition * 2));
                }
              
                if (currentNode.right != null) {
                    list.offer(new Pair<>(currentNode.right, currentPosition * 2 + 1));
                }
            }
        }
      
        return maxWidth;
    }
}