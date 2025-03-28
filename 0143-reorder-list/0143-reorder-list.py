# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        curr = slow
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        reversedList = self.reverseList(slow.next)
        slow.next = None
        while reversedList:
            nextCurr = curr.next
            nextRL = reversedList.next
            curr.next = reversedList
            reversedList.next = nextCurr
            curr = nextCurr
            reversedList = nextRL

    def reverseList(self, head: Optional[ListNode]) -> ListNode:
        if head is None or head.next is None:
            return head
        p = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return p
        
