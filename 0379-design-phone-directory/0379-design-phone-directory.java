class PhoneDirectory {
    
    Queue<Integer> slots;
    boolean[] isSlotAvailable;

    public PhoneDirectory(int maxNumbers) {
        isSlotAvailable = new boolean[maxNumbers];
        slots = new ArrayDeque<>(maxNumbers);

        Arrays.fill(isSlotAvailable, true);

        for (int i = 0; i < maxNumbers; i++) {
            slots.offer(i);
        }    
    }
    
    public int get() {
        if (slots.isEmpty()) {
            return -1;
        }

        int nextAvailableSlot = slots.poll();
        isSlotAvailable[nextAvailableSlot] = false;
        return nextAvailableSlot;
    }
    
    public boolean check(int number) {
        return isSlotAvailable[number];
    }
    
    public void release(int number) {
        if (isSlotAvailable[number]) {
            return;
        }

        isSlotAvailable[number] = true;
        slots.offer(number);
        return;
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */