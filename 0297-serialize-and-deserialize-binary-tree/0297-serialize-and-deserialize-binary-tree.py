# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root is None:
            return "N"
        
        stack = [root]
        preorder = []
        
        ## Pre order
        while stack:
            node = stack.pop()
            if node:
                preorder.append(str(node.val))
                stack.append(node.right)  
                stack.append(node.left)
            else:
                preorder.append("N")
        return ",".join(preorder)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        values = iter(data.split(","))
        
        def helper():
            val = next(values)
            if val == "N":
                return None
            node = TreeNode(int(val))
            node.left = helper()
            node.right = helper()
            return node
        
        return helper()
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))