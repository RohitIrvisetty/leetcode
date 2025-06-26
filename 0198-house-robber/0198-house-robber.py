class Solution:
    def rob(self, nums: List[int]) -> int:
        bounty = [None] * len(nums)
        if len(nums) == 0:
            return None
        if len(nums) == 1:
            return nums[0]
        bounty[0] = nums[0]
        bounty[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            bounty[i] = max(bounty[i - 2] + nums[i], bounty[i-1])
        return max(bounty)