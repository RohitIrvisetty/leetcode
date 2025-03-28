# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        res = TreeNode(-1)
        dummy = res
        stack = []
        if root is None:
            return stack
        stack.append(root)
        while stack:
            node = stack.pop()
            res.right = node
            res.left = None
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
            res = res.right
        return dummy.right

        