class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int i = 0, j = 1, k = 2;
        int count = 0;

        while (i < n) {

            while (j < n && (nums[j] - nums[i] < diff)) {
                j++;
            }

            if (j < n && nums[j] - nums[i] != diff) {
                i++;
                continue;
            }

            k = Math.max(k, j + 1);

            while (k < n && (nums[k] - nums[j] < diff)) {
                k++;
            }

            if (k < n && nums[k] - nums[j] == diff) {
                count++;
            }
            i++;
        }
        return count;
    }
}