class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        cumSum=0
        ans=[0]*len(nums)
        for i in range(len(nums)):
            ans[i]=cumSum+nums[i]
            cumSum+=nums[i]
        return ans