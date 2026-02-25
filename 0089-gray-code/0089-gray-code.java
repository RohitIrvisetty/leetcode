class Solution {
    public List<Integer> grayCode(int n) {
        int length = 1<<n;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            ans.add(i ^ (i >> 1));
        }

        return ans;
    }
}