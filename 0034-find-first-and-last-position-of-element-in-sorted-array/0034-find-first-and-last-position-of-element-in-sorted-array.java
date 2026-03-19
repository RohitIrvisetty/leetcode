class Solution {

    private int findFirstPosition(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1;
            } 

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return ans;
    }

    private int findLastPosition(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1;
            } 

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int firstPosition = findFirstPosition(nums, target);
        int lastPosition = findLastPosition(nums, target);

        return new int[] {firstPosition, lastPosition};

    }
}