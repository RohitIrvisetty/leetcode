class Node:
    def __init__(self, key, next = None, prev = None):
        self.key = key
        self.next = next
        self.prev = prev

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1

        node, value = self.cache[key]
        self._remove(node)
        self._add_to_front(node)
        return value

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node, value1 = self.cache[key]
            self._remove(node)
            self._add_to_front(node)
            self.cache[key] = (node, value)
        else:
            if len(self.cache) >= self.capacity:
                lru = self.tail.prev
                self._remove(lru)
                del self.cache[lru.key] 
            node = Node(key)
            self._add_to_front(node)
            self.cache[key] = (node, value)
            
    
    def _add_to_front(self, node):
        node.prev = self.head
        headNext = self.head.next
        self.head.next = node
        node.next = headNext
        headNext.prev = node

    def _remove(self, node):
        prev, nxt = node.prev, node.next
        prev.next = nxt
        nxt.prev = prev
