class Solution:
    def minMoves(self, nums):
        nums.sort()
        min = nums[0]
        result = 0
        for num in nums:
            result += num - min
        return result

        