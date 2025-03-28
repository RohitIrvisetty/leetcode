class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        sum=0
        if num%2!=0:
            return False
        for i in range(1,num//2+1):
            if num%i == 0:
                sum+=i
        return sum==num