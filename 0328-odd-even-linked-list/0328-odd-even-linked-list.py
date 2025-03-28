# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        evenNode = ListNode(0)
        oddNode = ListNode(1)
        evenHead = evenNode
        odddHead = oddNode
        isOdd = True
        while head:
            if isOdd:
                evenNode.next = head
                evenNode = evenNode.next
            else:
                oddNode.next = head
                oddNode = oddNode.next
            isOdd = not isOdd
            head = head.next
        oddNode.next = None
        evenNode.next = odddHead.next
        return evenHead.next