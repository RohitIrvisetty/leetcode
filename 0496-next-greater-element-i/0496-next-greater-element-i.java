class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hash = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                hash.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
        }

        while (!st.isEmpty()) {
            hash.put(st.pop(), -1);
        }

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            res[i] = hash.get(nums1[i]);    
        }
        return res;
    }
}