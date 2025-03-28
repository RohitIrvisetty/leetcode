# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        min_heap = []
        for i, node in enumerate(lists):
            if node:
                heapq.heappush(min_heap, (node.val, i, node))
        
        dummy = ListNode(-1)
        current = dummy
        while min_heap:
            min_val, idx, heapnode = heapq.heappop(min_heap)
            
            current.next = heapnode
            current = current.next
            if heapnode.next:
                heapq.heappush(min_heap, (heapnode.next.val, idx, heapnode.next))         
        return dummy.next
        