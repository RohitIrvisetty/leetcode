# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        curr = ListNode()
        dummy = curr
        flag = 1
        while head:
            revNode, revNodenext, nodesLessthanK = self.reverseSubList(head, k)
            head = revNodenext
            curr.next = revNode
            
            n = k + 1
            while n > 1 and nodesLessthanK:
                curr = curr.next
                n -= 1
            
        return dummy.next


    def reverseSubList(self, head: Optional[ListNode], k: int) -> [Optional[ListNode],  Optional[ListNode], int]:
        if k == 1:
            return [head, head.next, 1]
        
        if head is None or head.next is None:
            return [head, head.next, 0]
    
        node, nodeNext, nodesLessthanK = self.reverseSubList(head.next, k - 1)
        if nodesLessthanK:
            head.next.next = head
            head.next = None
            return [node, nodeNext, nodesLessthanK]
        return [head, nodeNext, nodesLessthanK]
        