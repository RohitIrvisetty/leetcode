class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        index = -1
        
        for i in range(n - 2, -1, -1):
            if nums[i] < nums[i + 1]:
                index = i
                break
        
        if index == -1:
            nums[:] = nums[::-1]
        else:

            min = float("inf")
            minIndex = 0
            for i in range(index + 1, n):
                if nums[i] < min and nums[i] > nums[index]:
                    min = nums[i]
                    minIndex = i
            print(index, minIndex)
            nums[index], nums[minIndex] = nums[minIndex], nums[index]
            
            nums[:] = nums[:index + 1] + sorted(nums[index + 1: ])