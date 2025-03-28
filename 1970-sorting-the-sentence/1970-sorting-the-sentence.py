class Solution:
    def sortSentence(self, s: str) -> str:
        arr =s.split()
        arr=sorted(arr, key=lambda x:x[-1])
        arr=map(lambda x:x[:-1], arr)
        return " ".join(arr)