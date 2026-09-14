class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> stacks;
    int maxFreq;

    public FreqStack() {
        maxFreq = 0;
        freq = new HashMap<>();
        stacks = new HashMap<>();    
    }
    
    public void push(int val) {
        int newFreq = freq.getOrDefault(val, 0) + 1;
        freq.put(val, newFreq);

        if (newFreq > maxFreq) {
            maxFreq = newFreq;

            if (!stacks.containsKey(newFreq)) {
                stacks.put(newFreq, new Stack<>());
            }
        }
        stacks.get(newFreq).push(val);
    }
    
    public int pop() {
        int val = stacks.get(maxFreq).pop();
        freq.put(val, freq.get(val) - 1);
        
        if (stacks.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */