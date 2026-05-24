class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int prevDiff = nums[1] - nums[0];
        int count = prevDiff != 0 ? 2 : 1;

        for (int i = 1; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];

            // sign changed
            if ((diff > 0 && prevDiff <= 0) ||
                (diff < 0 && prevDiff >= 0)) {

                count++;
                prevDiff = diff;
            }
        }

        return count;
    }
}