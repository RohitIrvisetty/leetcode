# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class HeapNode:
    def __init__(self, node):
        self.node = node

    def __lt__(self, other):
        # Define comparison based on ListNode's value
        return self.node.val < other.node.val

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        min_heap = []
        for i in lists:
            if i:
                heapq.heappush(min_heap, HeapNode(i))
        
        dummy = ListNode(-1)
        current = dummy
        while min_heap:
            heapnode = heapq.heappop(min_heap)
            node = heapnode.node
            current.next = node
            current = current.next
            if node.next:
                heapq.heappush(min_heap, HeapNode(node.next))         
        return dummy.next
        