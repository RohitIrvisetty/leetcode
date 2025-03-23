class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix_sums = {0: 1}  # Dictionary to store prefix sum frequencies
        count = 0
        current_sum = 0

        for num in nums:
            current_sum += num  # Update prefix sum
            count += prefix_sums.get(current_sum - k, 0)  # Check if (current_sum - k) exists
            prefix_sums[current_sum] = prefix_sums.get(current_sum, 0) + 1  # Store/update prefix sum frequency
        
        return count