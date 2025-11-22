class Solution:
    def minMoves(self, nums):
        mn = min(nums)
        result = 0
        for num in nums:
            result += num - mn
        return result

        