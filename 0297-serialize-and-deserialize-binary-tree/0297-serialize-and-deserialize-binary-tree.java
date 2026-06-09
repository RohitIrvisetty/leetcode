/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder output = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                output.append("#,");
            } else {
                output.append(node.val).append(',');

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return output.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        
        StringBuilder inputString = new StringBuilder(data);

        int firstComma = inputString.indexOf(",");
        String nodeVal = inputString.substring(0, firstComma);
        TreeNode root = new TreeNode(Integer.parseInt(nodeVal));
        inputString.delete(0, firstComma + 1);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            firstComma = inputString.indexOf(",");

            nodeVal = inputString.substring(0, firstComma);
            inputString.delete(0, firstComma + 1);

            if (!nodeVal.equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodeVal));
                node.left = leftNode;
                queue.offer(leftNode);
            }            

            
            firstComma = inputString.indexOf(",");

            nodeVal = inputString.substring(0, firstComma);
            inputString.delete(0, firstComma + 1);

            if (!nodeVal.equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodeVal));
                node.right = rightNode;
                queue.offer(rightNode);
            }   
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));