# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        def height(node, left):
            count = 0
            while node:
                count += 1
                node = node.left if left else node.right
            return count
            
        leftHeight = height(root, True)
        rightHeight = height(root, False)

        if leftHeight == rightHeight:
            return (1 << leftHeight) - 1
        
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)