class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        maxNumber=max(candies)
        result=[]
        for i in range(len(candies)):
            result.append(candies[i]+extraCandies>=maxNumber)
        return result       