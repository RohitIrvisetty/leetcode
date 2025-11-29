class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        obj = {}
        for i, num in enumerate(nums):
            if num in obj:
                return [obj[num], i]
            obj[target-num] = i