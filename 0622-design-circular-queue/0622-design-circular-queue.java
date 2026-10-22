class MyCircularQueue {
    
    int[] queue;
    int maxCapacity = 0;
    int currCapacity = 0;
    int head;

    public MyCircularQueue(int k) {
        this.maxCapacity = k;
        queue = new int[k];
        head = 0;
    }
    
    public boolean enQueue(int value) {
        if (currCapacity == maxCapacity) {
            return false;
        }

        this.queue[(head + currCapacity) % maxCapacity] = value;
        currCapacity++;
        return true;
    }
    
    public boolean deQueue() {
        if (currCapacity <= 0) {
            return false;
        }

        currCapacity--;
        head = (head + 1) % maxCapacity;
        return true;
    }
    
    public int Front() {
        if (currCapacity > 0) {
            return queue[head];
        }

        return -1;
    }
    
    public int Rear() {
        if (currCapacity > 0) {
            return queue[(head + currCapacity - 1) % maxCapacity];
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