class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        low= 0
        high = len(nums) - 1
        while low < high:
            mid = (high + low) // 2
            if (mid % 2 == 1) and nums[mid] == nums[mid - 1]:
                low = mid + 1
            elif (mid % 2 == 0) and nums[mid] == nums[mid + 1]:
                low = mid + 2
            else:
                high = mid
        return nums[high]
            
