class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        newIndex = (n - k) % n
        nums[:] = nums[newIndex: ] + nums[0: newIndex]
        