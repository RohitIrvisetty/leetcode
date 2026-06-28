class BSTIterator {

    private TreeNode curr;

    public BSTIterator(TreeNode root) {
        curr = root;
    }

    public boolean hasNext() {
        return curr != null;
    }

    public int next() {
        while (curr != null) {

            // No left subtree
            if (curr.left == null) {
                int ans = curr.val;
                curr = curr.right;
                return ans;
            }

            // Find inorder predecessor
            TreeNode pred = curr.left;

            while (pred.right != null && pred.right != curr) {
                pred = pred.right;
            }

            // Create thread
            if (pred.right == null) {
                pred.right = curr;
                curr = curr.left;
            }
            // Remove thread and visit
            else {
                pred.right = null;
                int ans = curr.val;
                curr = curr.right;
                return ans;
            }
        }

        return -1;
    }
}