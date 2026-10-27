class AllOne {

    class Node {
        int freq;
        Node next;
        Node prev;
        Set<String> keys;

        public Node(int freq) {
            this.freq = freq;
            keys = new HashSet<>();
        }
    }

    Node head;
    Node tail;
    Map<String, Node> keyToNodeMap = new HashMap<>();

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        keyToNodeMap = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (keyToNodeMap.containsKey(key)) {
            Node currNode = keyToNodeMap.get(key);
            Node nextNode = currNode.next;
            currNode.keys.remove(key);
            //keyToNodeMap.remove(key);

            if (nextNode == tail || nextNode.freq != currNode.freq + 1) {
                Node newNode = new Node(currNode.freq + 1);
                newNode.next = nextNode;
                newNode.prev = currNode;
                currNode.next = newNode;
                nextNode.prev = newNode;
                newNode.keys.add(key);
                keyToNodeMap.put(key, newNode);
            } else {
                nextNode.keys.add(key);
                keyToNodeMap.put(key, nextNode);
            }

            if (currNode.keys.isEmpty()) {
                removeNode(currNode);
            }

        } else {
            if (head.next == tail || head.next.freq != 1) {
                Node newNode = new Node(1);
                newNode.next = head.next;
                newNode.prev = head;
                head.next = newNode;
                newNode.next.prev = newNode;
                newNode.keys.add(key);
                keyToNodeMap.put(key, newNode);
            } else {
                head.next.keys.add(key);
                keyToNodeMap.put(key, head.next);
            }
        }
    }

    public void dec(String key) {
        if (!keyToNodeMap.containsKey(key)) {
            return;
        }

        Node currNode = keyToNodeMap.get(key);
        currNode.keys.remove(key);

        if (currNode.freq == 1) {
            keyToNodeMap.remove(key);
        } else {
            Node prevNode = currNode.prev;
            if (prevNode == head || prevNode.freq != currNode.freq - 1) {
                Node newNode = new Node(currNode.freq - 1);
                newNode.keys.add(key);
                newNode.prev = prevNode;
                newNode.next = currNode;
                prevNode.next = newNode;
                currNode.prev = newNode;
                keyToNodeMap.put(key, newNode);
            } else {
                prevNode.keys.add(key);
                keyToNodeMap.put(key, prevNode);
            }
        }

        if (currNode.keys.isEmpty()) {
            removeNode(currNode);
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }

        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }

        return head.next.keys.iterator().next();
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node = null;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */