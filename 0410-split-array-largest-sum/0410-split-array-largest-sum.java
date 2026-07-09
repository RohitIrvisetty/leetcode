class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int left = getMax(nums), right = getSum(nums);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid) <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int canSplit(int[] nums, int maxSplits, int largestSum) {
        int splits = 1;
        int sum = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] + sum <= largestSum) {
                sum += nums[i];
            } else {
                splits++;
                sum = nums[i];
            }
        }
        return splits;
    }

    private int getMax(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int num: nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int getSum(int[] nums) {
        int sum = 0;

        for (int num: nums) {
            sum += num;
        }
        return sum;
    }
}