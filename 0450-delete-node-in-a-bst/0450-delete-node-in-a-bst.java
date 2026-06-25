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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            return connector(root);
        }
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val > key) {
                if (curr.left != null && curr.left.val == key) {
                    curr.left = connector(curr.left);
                    break;
                } else {
                    curr = curr.left; 
                }
            } else if (curr.val < key) {
                if (curr.right != null && curr.right.val == key) {
                    curr.right = connector(curr.right);
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
        return root;

    }

    private TreeNode connector(TreeNode curr) {

        if (curr.left == null && curr.right == null) {
            return null;
        }

        if (curr.left == null) {
            return curr.right;
        }

        if (curr.right == null) {
            return curr.left;
        }

        TreeNode leftSubTree = curr.left;
        TreeNode rightSubTree = curr.right;
        TreeNode leftMostNodeInRightSubTree = curr.right;

        while (leftMostNodeInRightSubTree.left != null) {
            leftMostNodeInRightSubTree = leftMostNodeInRightSubTree.left;
        }

        leftMostNodeInRightSubTree.left = leftSubTree;

        return rightSubTree;
    }
}