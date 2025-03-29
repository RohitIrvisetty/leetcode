# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        # Check if there are at least k nodes to reverse
        curr = head
        count = 0
        while curr and count < k:
            curr = curr.next
            count += 1
        
        if count == k:
            # Reverse k nodes
            prev, curr = None, head
            for _ in range(k):
                nxt = curr.next
                curr.next = prev
                prev = curr
                curr = nxt
            
            # Recursively call for next part of the list
            head.next = self.reverseKGroup(curr, k)
            return prev  # prev is the new head after reversing k nodes
        
        return head  # Not enough nodes to reverse, return head as is
        