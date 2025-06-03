class Solution:
    def reverse(self, n: int) -> int:
        revNum = 0
        sign = 1
        if n < 0:
            sign = -1
            n *= -1
        while n > 0:
            lastDigit = n % 10
            revNum = (revNum * 10) + lastDigit
            if revNum > 2**31 - 1:
                return 0
            n = n // 10

        if sign == -1:
            return -1 * revNum
        
        return revNum