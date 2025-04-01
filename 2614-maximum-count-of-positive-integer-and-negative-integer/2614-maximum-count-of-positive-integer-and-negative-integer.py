class Solution:
    def firstPositiveIndex(nums):
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] > 0:
                right = mid - 1  # Move left to find the first occurrence
            else:
                left = mid + 1  # Keep looking in the right half
        return left  # First index where a positive number appears

    def firstNonNegativeIndex(nums):
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] >= 0:
                right = mid - 1  # Move left to find the first non-negative number
            else:
                left = mid + 1
        return left  # First index where a non-negative number appears

    def maximumCount(self, nums):
        pos_index = Solution.firstPositiveIndex(nums)  # First positive number index
        pos_count = len(nums) - pos_index  # Count of positive numbers

        neg_index = Solution.firstNonNegativeIndex(nums)  # First non-negative number index
        neg_count = neg_index  # Count of negative numbers

        return max(pos_count, neg_count)