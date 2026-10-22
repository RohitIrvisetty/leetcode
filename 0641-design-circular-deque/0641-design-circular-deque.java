class MyCircularDeque {
    int[] arr;
    int front;
    int tail;
    int currCapacity, maxCapacity;

    public MyCircularDeque(int k) {
        arr = new int[k];
        front = 0;
        tail = 0;
        currCapacity = 0;
        maxCapacity = k;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        front = (front - 1 + maxCapacity) % maxCapacity;
        arr[front] = value;
        currCapacity++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        arr[tail] = value;
        tail = (tail + 1) % maxCapacity;
        currCapacity++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % maxCapacity;
        currCapacity--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail = (tail - 1 + maxCapacity) % maxCapacity;
        currCapacity--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return arr[(tail - 1 + maxCapacity) % maxCapacity];
    }
    
    public boolean isEmpty() {
        return currCapacity == 0;
    }
    
    public boolean isFull() {
        return maxCapacity == currCapacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */