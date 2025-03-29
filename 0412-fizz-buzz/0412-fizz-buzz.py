class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        ans = [0] * n
        for i in range(1, n + 1):
            div_3 = (i%3 == 0)
            div_5 = (i%5 == 0)
            if div_3 & div_5:
                ans[i - 1] = "FizzBuzz"
            elif div_3:
                ans[i - 1] = "Fizz"
            elif div_5:
                ans[i - 1] = "Buzz"
            else:
                ans[i - 1] = str(i)
        return ans