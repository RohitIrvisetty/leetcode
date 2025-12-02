class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n = len(nums)
        maj = n // 2
        count = 0
        elem = 0
        for i in range(n):
            if count == 0:
                elem = nums[i]
                count += 1
            elif elem == nums[i]:
                count += 1
            else:
                count -= 1
        count = 0
        for i in range(n):
            if nums[i] == elem:
                count += 1
        return elem if count >= maj else -1

        