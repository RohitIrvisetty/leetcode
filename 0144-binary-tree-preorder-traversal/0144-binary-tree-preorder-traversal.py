class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        curr = root

        while curr is not None:
            if curr.left is None:
                res.append(curr.val)
                curr = curr.right  # move to next right node
            else:
                pre = curr.left
                while pre.right is not None and pre.right != curr:  # find rightmost
                    pre = pre.right

                if pre.right is None:
                    # establish a link back to the current node
                    res.append(curr.val)
                    pre.right = curr
                    curr = curr.left
                else:
                    # restore the tree structure
                    pre.right = None
                    curr = curr.right

        return res
