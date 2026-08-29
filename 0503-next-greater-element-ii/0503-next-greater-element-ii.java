class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < 2 * n; i++) {
            int current = nums[i % n];
            
            while (!st.isEmpty() && nums[st.peek()] < current) {
                res[st.pop()] = current;
            }

            if (i < n) {
                st.push(i);
            }
        }


        return res;
    }
}