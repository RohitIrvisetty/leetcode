class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        minimum = float("inf")
        for i in range(len(nums)):
            left_pointer = i+1
            right_pointer = len(nums) - 1
            while left_pointer < right_pointer:
                sum = nums[i] + nums[left_pointer] + nums[right_pointer]
                if abs(target - sum) < abs(minimum):
                    minimum = target - sum
                if sum < target:
                    left_pointer += 1
                else:
                    right_pointer -= 1
            if minimum == 0:
                    break
        return target - minimum