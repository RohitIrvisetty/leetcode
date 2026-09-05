class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        int current = 0;

        Arrays.fill(ans, 0);

        while (current < n) {
            while (!st.isEmpty() && temperatures[current] > temperatures[st.peek()]) {
                ans[st.peek()] = current - st.peek();
                st.pop();
            }
            st.push(current++);
        }
        return ans;
    }
}