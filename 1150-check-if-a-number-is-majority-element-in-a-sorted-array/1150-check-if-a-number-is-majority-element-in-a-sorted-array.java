class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int firstIndex = lowerBound(nums, target);

        return (firstIndex + nums.length / 2) < n && nums[firstIndex + nums.length / 2] == target;      
    }

    private int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}