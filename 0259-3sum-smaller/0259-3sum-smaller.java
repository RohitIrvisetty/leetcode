class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            count += twoSum(nums, i, target);
        }

        return count;
    }

    private int twoSum(int[] nums, int i, int target) {
        int n = nums.length;
        int left = i + 1;
        int right = n - 1;
        int count = 0;

        while (left < right) {
            int sum = nums[left] + nums[right] + nums[i];

            if (sum < target) {
                count += (right - left);
                left++;
            } else if (sum >= target) {
                right--;
            }
        }

        return count;
    }
}