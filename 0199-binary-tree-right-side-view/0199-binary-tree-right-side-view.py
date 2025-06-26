# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = {}
        stack = []
        if root is None:
            return []
        
        if root.left is None and root.right is None:
            return [root.val]
        
        stack.append((root, 0, 0))
        while stack:
            (node, row, col) = stack.pop(0)
            res[row] = node.val
            if node.left:
                stack.append((node.left, row + 1, col - 1))
            if node.right:
                stack.append((node.right, row + 1, col + 1))
        return list(res.values())
