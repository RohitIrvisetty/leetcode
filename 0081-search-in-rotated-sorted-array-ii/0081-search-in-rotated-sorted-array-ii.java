class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println(mid + " " + left + " " + right);
            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[right] && nums[mid] == nums[right]) {
                left += 1;
                right -= 1;
            }
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}