class MyCircularQueue {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    int maxCapacity = 0;
    int currCapacity = 0;
    Node head, tail;

    public MyCircularQueue(int k) {
        this.maxCapacity = k;
    }
    
    public boolean enQueue(int value) {
        if (currCapacity == maxCapacity) {
            return false;
        }

        Node newNode = new Node(value);
        if (currCapacity == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        currCapacity++;
        return true;
    }
    
    public boolean deQueue() {
        if (currCapacity <= 0) {
            return false;
        }

        currCapacity--;
        head = head.next;
        return true;
    }
    
    public int Front() {
        if (currCapacity > 0) {
            return head.val;
        }

        return -1;
    }
    
    public int Rear() {
        if (currCapacity > 0) {
            return tail.val;
        }
        
        return -1;
    }
    
    public boolean isEmpty() {
        return currCapacity == 0;
    }
    
    public boolean isFull() {
        return maxCapacity == currCapacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */