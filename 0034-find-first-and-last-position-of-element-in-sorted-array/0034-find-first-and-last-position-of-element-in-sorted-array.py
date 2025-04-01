class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def findBound(isLeft):
            left = 0
            right = len(nums) - 1
            bound = -1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    bound = mid
                    if isLeft:
                        right = mid - 1
                    else:
                        left = mid + 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return bound
        
        start = findBound(True)
        end = findBound(False)

        return [start, end]