class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        output=""
        n=max(len(word1),len(word2))
        for i in range(n):
            if i<len(word1):
                output+=word1[i]
            if i<len(word2):
                output+=word2[i]
        return output