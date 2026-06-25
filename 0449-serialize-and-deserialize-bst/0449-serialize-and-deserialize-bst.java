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
        StringBuilder output = new StringBuilder();
        dfs(root, output);
        return output.toString();
    }

    private void dfs(TreeNode root, StringBuilder output) {
        if (root == null) {
            return;
        }

        output.append(String.valueOf(root.val)).append(",");
        dfs(root.left, output);
        dfs(root.right, output);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        
        StringBuilder inputString = new StringBuilder(data);

        int firstComma = inputString.indexOf(",");
        int rootValue = Integer.parseInt(inputString.substring(0, firstComma));
        inputString.delete(0, firstComma + 1);
        
        TreeNode root = new TreeNode(rootValue);
        
        while (!inputString.isEmpty()) {
            firstComma = inputString.indexOf(",");
            int nodeValue = Integer.parseInt(inputString.substring(0, firstComma));
            inputString.delete(0, firstComma + 1);
            insertIntoBST(root, nodeValue);
        }

        return root;
    }

    private void insertIntoBST(TreeNode root, int nodeValue) {
        while (root != null) {
            if (root.val >= nodeValue) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root.left = new TreeNode(nodeValue);
                    return;
                }
            } else {
                if (root.right != null) {
                    root = root.right;
                } else {
                    root.right = new TreeNode(nodeValue);
                    return;
                }
            }
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;