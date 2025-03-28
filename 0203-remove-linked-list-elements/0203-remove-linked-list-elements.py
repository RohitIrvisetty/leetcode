# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        curr = head
        prev = ListNode(0)
        prev.next = head
        sentinel = prev
        while curr:
            if curr.val == val:
                sentinel.next = curr.next
            else:
                sentinel = curr
            curr = curr.next
        return prev.next
        