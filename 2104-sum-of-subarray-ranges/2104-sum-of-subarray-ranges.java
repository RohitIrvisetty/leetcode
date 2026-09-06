class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] <= nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty()? -1: st.peek();
                int right = i;

                int count = (mid - left) * (right - mid);
                ans += count * (long) nums[mid];
            }
            st.push(i);
        } 

        st.clear();

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] >= nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty()? -1: st.peek();
                int right = i;

                int count = (mid - left) * (right - mid);
                ans -= count * (long) nums[mid];
            }
            st.push(i);
        } 
        return ans;

    }
}