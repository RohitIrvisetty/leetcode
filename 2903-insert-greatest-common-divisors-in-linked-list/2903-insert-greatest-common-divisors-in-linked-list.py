# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        node1 = head
        node2 = head.next

        while node1 and node2:
            gcd = self._cal_gcd_(node1.val, node2.val)
            gcdNode = ListNode(gcd)

            node1.next = gcdNode
            gcdNode.next = node2

            node1 = node2
            node2 = node2.next
        
        return head
    
    def _cal_gcd_(self, num1, num2):
        while num2 != 0:
            num1, num2 = num2, num1 % num2
        return num1