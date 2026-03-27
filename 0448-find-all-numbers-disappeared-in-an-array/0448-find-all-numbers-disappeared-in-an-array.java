class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        // cyclic sort

        int i = 0, n = nums.length;
        List<Integer> missing = new ArrayList<>();
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                missing.add(j + 1);
            }
        }
        return missing;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j]; 
    }
}