class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        num = x ^ y
        return bin(num)[2:].count('1')