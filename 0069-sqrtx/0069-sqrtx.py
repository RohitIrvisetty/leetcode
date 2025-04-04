class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x
        left, right = 1, x // 2
        res = 0
        while left <= right:
            mid = (left+right)//2
            if mid * mid == x:
                return mid
            if mid * mid < x:
                res = mid
                left = mid + 1
            else:
                right = mid - 1
        return res