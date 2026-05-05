class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 1, repeatCount = 0;
        int prevNum = Integer.MIN_VALUE;

        for (int num: nums) {
            if (num > prevNum) {
                repeatCount++;
                maxLen = Math.max(maxLen, repeatCount);
                prevNum = num;
            } else {
                repeatCount = 1;
                prevNum = num;
            }
        }
        return maxLen;
    }
}