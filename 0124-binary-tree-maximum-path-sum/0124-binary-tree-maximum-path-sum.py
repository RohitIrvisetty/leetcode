# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        maxSum = []
        self.help(root, maxSum)
        return max(maxSum)

    def help(self, root: Optional[TreeNode], maxSum: Optional[int]) -> int:
        if root is None:
            return 0
        
        left = max(0, self.help(root.left, maxSum))
        right = max(0, self.help(root.right, maxSum))
        maxSum.append(left + right + root.val)
        return max(right, left) + root.val







# class Solution:
#     def findMaxPathSum(self, root, maxi):
#         if root is None:
#             return 0

#         leftMaxPath = max(0, self.findMaxPathSum(root.left, maxi))
#         rightMaxPath = max(0, self.findMaxPathSum(root.right, maxi))

#         maxi[0] = max(maxi[0], leftMaxPath + rightMaxPath + root.data)

#         # Return the maximum sum considering
#         # only one branch (either left or right)
#         # along with the current node
#         return max(leftMaxPath, rightMaxPath) + root.data

                           
                        