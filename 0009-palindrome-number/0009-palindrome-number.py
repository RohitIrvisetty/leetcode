class Solution:
    def isPalindrome(self, x: int) -> bool:
        sign = 1
        if x < 0:
            sign = -1
        revNum = int(str(sign * x)[::-1])
        return x == revNum