"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        node = head
        while node:
            next = node.next
            copyNode = Node(node.val)
            node.next = copyNode
            copyNode.next = next
            node = node.next.next
        node = head
        while node:
            copyNode = node.next
            if node.random:
                randomNode = node.random.next
            else:
                randomNode = None
            copyNode.random = randomNode
            node = node.next.next
        node = head
        dummyNode = Node(-1)
        res = dummyNode
        while node:
            res.next = node.next
            res = res.next
            node = node.next.next
        return dummyNode.next