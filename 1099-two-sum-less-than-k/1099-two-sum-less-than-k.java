class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int left = 0, right = n - 1;
        int ans = -1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum < k) {
                ans = Math.max(ans, sum);
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}