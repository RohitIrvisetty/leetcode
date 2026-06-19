class MinStack {
    private Stack<Long> st;
    private long mini;

    // Empty Constructor
    public MinStack() {
        st = new Stack<>();
    }

    // Method to push a value in stack
    public void push(int value) {
        // If stack is empty
        if (st.isEmpty()) {
            // Update the minimum value
            mini = value;

            // Push current value as minimum
            st.push((long) value);
            return;
        }

        // If the value is greater than the minimum
        if (value > mini) {
            st.push((long) value);
        } else {
            // Add the modified value to stack
            st.push(2L * value - mini);
            // Update the minimum
            mini = value;
        }
    }

    // Method to pop a value from stack
    public void pop() {
        // Base case
        if (st.isEmpty()) return;

        // Get the top
        long x = st.pop();

        // If the modified value was added to stack
        if (x < mini) {
            // Update the minimum
            mini = 2L * mini - x;
        }
    }

    // Method to get the top of stack
    public int top() {
        // Base case
        if (st.isEmpty()) return -1;

        // Get the top
        long x = st.peek();

        // Return top if minimum is less than the top
        if (mini < x) return (int) x;

        // Otherwise return mini
        return (int) mini;
    }

    // Method to get the minimum in stack
    public int getMin() {
        // Return the minimum
        return (int) mini;
    }
}