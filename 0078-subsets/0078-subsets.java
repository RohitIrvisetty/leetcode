class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int subSetsCount = 1 << nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < subSetsCount; i++) {
            List<Integer> subSet = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subSet.add(nums[j]);
                }
            }
            result.add(subSet);
        }
        return result;
        
    }
}