# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        length = 1
        curr = head
        if not head:
            return None
        if not head.next:
            return head
        while curr.next:
            length += 1
            curr = curr.next
        curr.next = head
        newcurr = head
        for i in range (0, (length - k % length - 1)):
            newcurr = newcurr.next
        newhead = newcurr.next
        newcurr.next = None
        return newhead