class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        MOD = 10**9 + 7
        odd = 0
        even = 0
        vk = 0
        ans = 0
        for num in arr:
            vk+=num
            if vk%2 == 1:
                odd += 1
                ans += 1 + even
            else:
                even += 1
                ans += odd
        
        return ans%MOD