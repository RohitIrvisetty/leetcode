class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> missing = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }


        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing.add(i + 1);
            }
        }

        return missing;
    }
}