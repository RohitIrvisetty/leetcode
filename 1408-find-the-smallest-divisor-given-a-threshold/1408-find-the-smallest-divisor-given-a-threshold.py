class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        def compute_sum(divisor):
            return sum((num + divisor - 1) // divisor for num in nums)  # ceil division

        left, right = 1, max(nums)
        answer = right

        while left <= right:
            mid = (left + right) // 2
            if compute_sum(mid) <= threshold:
                answer = mid
                right = mid - 1
            else:
                left = mid + 1

        return answer