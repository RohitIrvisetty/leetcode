```java
import java.util.HashMap;
import java.util.Map;

class LFUCache {

    // Node represents one key-value pair
    // and stores its current frequency.
    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1; // Every new node starts with frequency 1
        }
    }

    // Doubly linked list for nodes having the same frequency.
    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            // Dummy nodes make insertion/removal easier.
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        // Add node right after head.
        // This makes it the MOST RECENTLY USED node.
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        // Remove a specific node from the list.
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        // Remove and return the LEAST RECENTLY USED node.
        // The LRU node is right before tail.
        Node removeLast() {
            if (size == 0) {
                return null;
            }

            Node node = tail.prev;
            remove(node);

            return node;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    // key -> Node
    // Allows us to find a node in O(1).
    Map<Integer, Node> keyToNode;

    // frequency -> doubly linked list of nodes
    Map<Integer, DoublyLinkedList> freqToList;

    int capacity;

    // Smallest frequency currently present in the cache.
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;

        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {

        // Key doesn't exist.
        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        Node node = keyToNode.get(key);

        // Accessing the node increases its frequency.
        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        // If capacity is 0, we cannot store anything.
        if (capacity == 0) {
            return;
        }

        // Key already exists.
        if (keyToNode.containsKey(key)) {

            Node node = keyToNode.get(key);

            // Update value.
            node.value = value;

            // Updating an existing key counts as using it.
            increaseFrequency(node);

            return;
        }

        // Cache is full.
        if (keyToNode.size() == capacity) {

            // We must remove the LFU node.
            // If multiple nodes have the same frequency,
            // remove the LRU node from that frequency list.
            DoublyLinkedList list = freqToList.get(minFreq);

            Node nodeToRemove = list.removeLast();

            // Remove it from key -> node map.
            keyToNode.remove(nodeToRemove.key);
        }

        // Create new node.
        Node newNode = new Node(key, value);

        // New nodes have frequency 1.
        keyToNode.put(key, newNode);

        // Get the frequency-1 list.
        if (!freqToList.containsKey(1)) {
            freqToList.put(1, new DoublyLinkedList());
        }

        // Add new node as most recently used.
        freqToList.get(1).addFirst(newNode);

        // Since we inserted a frequency-1 node,
        // the minimum frequency is now 1.
        minFreq = 1;
    }

    // Moves a node from frequency f to frequency f + 1.
    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        // Get the list containing this node.
        DoublyLinkedList oldList = freqToList.get(oldFreq);

        // Remove node from its old frequency list.
        oldList.remove(node);

        // If this was the minimum frequency and
        // the list became empty, increase minFreq.
        if (oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        // Increase node's frequency.
        node.freq++;

        int newFreq = node.freq;

        // Create the new frequency list if necessary.
        if (!freqToList.containsKey(newFreq)) {
            freqToList.put(newFreq, new DoublyLinkedList());
        }

        // Add node as MOST RECENTLY USED in the new list.
        freqToList.get(newFreq).addFirst(node);
    }
}
```
