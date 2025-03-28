class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        min = float("inf")
        for i in prices:
            if i < min:
                min = i
            if i - min > profit:
                profit = i - min
        return profit