class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        output=list(map(lambda x: x*x, nums))
        return sorted(output)