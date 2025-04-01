class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1

        while left < right:
            mid = (left + right) // 2

            if nums[mid] > nums[right]:  # Min must be in right half
                left = mid + 1
            else:  # Min is in left half (including mid)
                right = mid
        return nums[left]

        