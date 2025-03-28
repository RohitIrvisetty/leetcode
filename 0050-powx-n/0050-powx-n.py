class Solution:
    def findPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0:
            return self.findPow(1/x, -1 * n)
        if n % 2 == 0:
            return self.findPow(x * x, n / 2)
        else:
            return x * self.findPow(x * x, (n - 1) / 2)
    def myPow(self, x: float, n: int) -> float:
        return self.findPow(x, n)