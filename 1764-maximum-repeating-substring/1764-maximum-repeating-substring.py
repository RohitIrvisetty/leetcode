class Solution:
    def maxRepeating(self, sequence: str, word: str) -> int:
        if not word:
            return 0
        k=0
        count=0
        temp=word
        while temp in sequence:
            k+=1
            temp+=word
            count=max(count,k)
        return count