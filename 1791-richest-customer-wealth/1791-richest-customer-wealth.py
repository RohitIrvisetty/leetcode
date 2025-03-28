class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        sumAccounts=[sum(x) for x in accounts]
        return max(sumAccounts)