class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int left = 0, right = 0;
        int maxLen = 0, len = 0, flips = 0;

        while (right < n) {
            if (nums[right] == 1) {
                len++;
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
                continue;
            } 

            while (flips > 0) {
                if (nums[left] == 0) {
                    flips--;
                }
                left++;
            }
            flips++;
            len++;
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}