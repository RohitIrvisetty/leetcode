class Solution:
    def fib(self, n: int) -> int:
        output=[0,1]
        for i in range(2, n+1):
            output.append(output[i-1]+output[i-2])
        return output[n]
        