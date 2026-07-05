class Solution {
    public int maximumCount(int[] nums) {
        int pos_count = countPositives(nums);
        int neg_count = countNegatives(nums);

        System.out.println(pos_count + "  " + neg_count);
        return Math.max(pos_count, neg_count);
    }

    private int countPositives(int[] nums) {
        int n = nums.length;

        int left = 0, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return n - left;
    }

    private int countNegatives(int[] nums) {
        int n = nums.length;

        int left = 0, right = n;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}