class Solution:
    def kthFactor(self, n: int, k: int) -> int:
        ans=[1,n]
        for i in range(2,(n//2)+1):
            if n%i==0:
                ans+=[i]
        ans.sort()
        if k<=len(ans):
            return ans[k-1]
        else:
            return -1        