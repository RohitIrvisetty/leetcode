class Solution:
    def longestPalindrome(self, s: str) -> str:
        ans = [0, 0]
        n = len(s)
        def check_palindrome(left: int, right: int) -> int:
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return right - left - 1
        for i in range(n):
            odd_check_length = check_palindrome(i, i)
            even_check_length = check_palindrome(i, i + 1)
            maxlen = max(odd_check_length, even_check_length)
            if maxlen > (ans[1] - ans[0]):
                ans[0] = i - (maxlen - 1)//2
                ans[1] = i + maxlen//2
        return s[ans[0]: ans[1] + 1]

    