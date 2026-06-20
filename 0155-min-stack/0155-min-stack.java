class MinStack {
    
    private Stack<Long> st;
    private long min;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        if (st.isEmpty()) {
            st.push(0L);
            min = value;
            return;
        }   

        st.push(value - min);
        if (value < min) {
            min = value;
        }
    }
    
    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        
        long ele = st.pop();

        if (ele < 0) {
            min = min - ele;
        }
    }
    
    public int top() {
        if (st.isEmpty()) {
            return -1;
        }

        long top = st.peek();

        if (top < 0) {
            return (int) min;
        }

        return (int) min + (int) top;
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