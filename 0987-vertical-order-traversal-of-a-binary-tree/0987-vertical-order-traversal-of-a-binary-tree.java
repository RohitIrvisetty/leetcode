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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> nodeList = new ArrayList<>();

        traverseTree(root, 0, 0, nodeList);
      
        Collections.sort(nodeList, (nodeA, nodeB) -> {
            if (nodeA.get(0) != nodeB.get(0)) {
                return nodeA.get(0) - nodeB.get(0);
            }
            if (nodeA.get(1) != nodeB.get(1)) {
                return nodeA.get(1) - nodeB.get(1);
            }
            return nodeA.get(2) - nodeB.get(2);
        });
      
        // Build the result list by grouping nodes by column
        List<List<Integer>> result = new ArrayList<>();

        int previousColumn = Integer.MIN_VALUE;
      
        for (List<Integer> nodeInfo : nodeList) {
            int column = nodeInfo.get(0);
            int nodeValue = nodeInfo.get(2);
          
            // Start a new column group if column index changes
            if (previousColumn != column) {
                result.add(new ArrayList<>());
                previousColumn = column;
            }
          
            // Add node value to the current column group
            result.get(result.size() - 1).add(nodeValue);
        }
      
        return result;
    }

   
     private void traverseTree(TreeNode node, int row, int column, List<List<Integer>> nodeList) {
        if (node == null) {
            return;
        }
      
        nodeList.add(Arrays.asList(column, row, node.val));
      
        traverseTree(node.left, row + 1, column - 1, nodeList);
      
        traverseTree(node.right, row + 1, column + 1, nodeList);
    }
}