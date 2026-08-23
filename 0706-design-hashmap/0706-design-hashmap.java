class MyHashMap {
    class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private static final int SIZE = 1009;
    private Node[] buckets;

    public MyHashMap() {    
        buckets = new Node[SIZE];
    }
    
    private int getHash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int hashKey = getHash(key);
        Node curr = buckets[hashKey];

        if (curr == null) {
            buckets[hashKey] = new Node(key, value);
            return;
        }

        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }

            curr = curr.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = buckets[hashKey];
        buckets[hashKey] = newNode;
    }
    
    public int get(int key) {
        int hashKey = getHash(key);
        Node curr = buckets[hashKey];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }

            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hashKey = getHash(key);
        Node curr = buckets[hashKey];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[hashKey] = curr.next;
                    return;
                } else {
                    prev.next = curr.next;
                    return;
                }
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */