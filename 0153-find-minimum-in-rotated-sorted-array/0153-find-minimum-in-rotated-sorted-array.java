class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid = (left + right) / 2;

        while (left < right) {
            mid = (left + right) / 2;

            if (nums[right] < nums[mid]) {
               left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}