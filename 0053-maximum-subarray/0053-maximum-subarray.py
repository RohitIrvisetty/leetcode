class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxSum = float("-inf")
        summation = 0
        n = len(nums)
        for i in range(n):
            summation += nums[i]
            maxSum = max(maxSum, summation)

            if summation < 0:
                summation = 0
            
        return maxSum