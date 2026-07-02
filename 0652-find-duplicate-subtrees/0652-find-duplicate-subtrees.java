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
public class Solution {
    private Map<String, Integer> idMap;
    private Map<Integer, Integer> count;
    private List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        idMap = new HashMap<>();
        count = new HashMap<>();
        res = new ArrayList<>();

        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return -1;
        String cur = dfs(node.left) + "," + node.val + "," + dfs(node.right);
        idMap.putIfAbsent(cur, idMap.size());
        int curId = idMap.get(cur);
        count.put(curId, count.getOrDefault(curId, 0) + 1);
        if (count.get(curId) == 2) {
            res.add(node);
        }
        return curId;
    }
}