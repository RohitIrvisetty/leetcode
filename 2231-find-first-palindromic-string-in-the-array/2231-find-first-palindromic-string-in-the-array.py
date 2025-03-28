class Solution:
    def firstPalindrome(self, words: List[str]) -> str:
        for word in words:
            revWord=word[::-1]
            if word==revWord:
                return word
        return ""