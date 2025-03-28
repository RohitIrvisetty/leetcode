class Solution:
    def buildArray(self, nums: List[int]) -> List[int]:
        ans=list(map(lambda x: nums[x], nums))
        return ans