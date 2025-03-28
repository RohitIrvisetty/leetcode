# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        queue = []
        if root is None:
            return res
        queue.append(root)
        zigzagFlag = True 
        while queue:
            size = len(queue)
            nodeLevel = [0] * size
            for i in range(size):
                node = queue.pop(0)
                index = i if zigzagFlag else (size - 1 - i)
                nodeLevel[index] = node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                
            zigzagFlag = not zigzagFlag
            res.append(nodeLevel)
            
        return res