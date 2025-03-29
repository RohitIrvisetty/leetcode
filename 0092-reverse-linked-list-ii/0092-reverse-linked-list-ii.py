class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if not head or left == right:
            return head

        dummy = ListNode(0)
        dummy.next = head
        prev = dummy

        # Move prev to the node just before 'left'
        for _ in range(left - 1):
            prev = prev.next


        # Reverse the sublist from left to right
        curr = prev.next
        prev_sublist = None

        for _ in range(right - left + 1):
            next_node = curr.next
            curr.next = prev_sublist
            prev_sublist = curr
            curr = next_node
        print(prev_sublist)
        print(curr)
        print(prev)
        # Connect the reversed sublist back to the original list
        
        prev.next.next = curr
        print(prev)
        prev.next = prev_sublist
        print(prev)
        
        return dummy.next