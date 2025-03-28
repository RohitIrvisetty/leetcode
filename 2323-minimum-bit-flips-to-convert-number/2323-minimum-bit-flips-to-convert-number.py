class Solution:
    def minBitFlips(self, start: int, goal: int) -> int:
        num = start ^ goal
        return bin(num)[2:].count('1')
        