class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        obj = {}
        for i, j in enumerate(numbers):
            if j in obj:
                return [obj[j], i + 1] 
            obj[target - j] = i + 1

        