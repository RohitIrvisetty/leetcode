class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        out=0
        for i in s:
            out^=ord(i)
        for i in t:
            out^=ord(i)
        return chr(out)
        