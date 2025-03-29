class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if left == right:
            return head
        dummy = ListNode(-1)
        prev = dummy
        prev.next = head

        for i in range(left - 1):
            prev = prev.next

        curr = prev.next
        prev_sublist = None

        for i in range(right - left + 1):
            nextNode = curr.next
            curr.next = prev_sublist
            prev_sublist = curr
            curr = nextNode
        
        print(prev_sublist)

        prev.next.next = curr
        prev.next = prev_sublist
        return dummy.next