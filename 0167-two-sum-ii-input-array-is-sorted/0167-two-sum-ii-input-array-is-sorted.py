class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        p0 = 0
        p1 = len(numbers) - 1
        while p0 < p1:
            if numbers[p0] + numbers[p1] == target:
                return [p0 + 1, p1 + 1]
            elif numbers[p0] + numbers[p1] > target:
                p1 = p1 - 1
            else:
                p0 = p0 + 1
        


        