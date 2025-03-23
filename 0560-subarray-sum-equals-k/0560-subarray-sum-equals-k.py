class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        sumMap = {0: 1}
        count = 0
        n = len(nums)
        current_sum = 0

        for i in range(n):
            current_sum += nums[i]            
            rem = current_sum - k

            if rem in sumMap:
                count += sumMap[rem]

            if current_sum not in sumMap:
                sumMap[current_sum] = 1
            else:
                sumMap[current_sum] = sumMap[current_sum] + 1
        return count