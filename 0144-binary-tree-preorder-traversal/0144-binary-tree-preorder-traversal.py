class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self.res = []
        
        self.helper(root)
        return self.res

    def helper(self, root):
        if root is not None:
            self.res.append(root.val)
            self.helper(root.left)
            self.helper(root.right)