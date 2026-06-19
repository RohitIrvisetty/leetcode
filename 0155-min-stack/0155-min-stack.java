class MinStack {
    private Stack<Long> st = new Stack<>();
    private long min;

    public MinStack() {
        st = new Stack<>();    
    }
    
    public void push(int value) {
        if (st.isEmpty()) {
            st.push((long) value);
            min = value;
            return;
        }

        if (value > min) {
            st.push((long) value);
        } else {
            st.push(2L * value - min);
            min = value;
        }
    }
    
    public void pop() {
        if (st.isEmpty()) {
            return;
        }

        long x = st.pop();

        if (min >= x) {
            min = 2L * min - x;
        }
    }
    
    public int top() {
        if (st.isEmpty()) {
            return -1;
        }

        long top = st.peek();

        if (min < top) {
            return (int) top;
        } else {
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */