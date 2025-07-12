# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        res = []
        stack = []
        if root is None:
            return None
        
        current = root
        counter = 0
        while stack or current:
            while current:
                stack.append(current)
                current = current.left
            current = stack.pop()
            res.append(current.val)
            counter += 1
            if counter == k:
                return current.val
            current = current.right
        return res[k - 1]

        