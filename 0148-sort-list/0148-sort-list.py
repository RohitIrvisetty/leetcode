
class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        return self.mergeSort(head)


        
    def mergeSort(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        
        slow = head
        fast = head.next
        left = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        right = slow.next
        slow.next = None

        leftHead = self.mergeSort(left)
        rightHead = self.mergeSort(right)
        return self.merge(leftHead, rightHead)
    
    def merge(self, leftHead: ListNode, rightHead: ListNode) -> ListNode:
        curr = ListNode(-1)
        dummy = curr
        while leftHead and rightHead:
            if leftHead.val <= rightHead.val:
                dummy.next = leftHead
                leftHead = leftHead.next
            else:
                dummy.next = rightHead
                rightHead = rightHead.next
            dummy = dummy.next
        
        if leftHead:
            dummy.next = leftHead
        else:
            dummy.next = rightHead
        
        return curr.next