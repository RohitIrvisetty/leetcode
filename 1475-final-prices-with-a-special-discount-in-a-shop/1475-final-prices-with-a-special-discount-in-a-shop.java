class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = prices.clone();

        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                ans[st.peek()] = ans[st.peek()] - prices[i];
                st.pop();
            }
            st.push(i);
        }
        
        return ans;
    }
}