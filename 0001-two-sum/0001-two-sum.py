class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        obj = {}
        for i, j in enumerate(nums):
            if j in obj:
                return [i, obj[j]]
            obj[target - j] = i
        