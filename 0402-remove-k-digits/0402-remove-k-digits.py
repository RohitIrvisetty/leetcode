class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        n = len(num)
        if n == k:
            return "0"
        stack = []
        for i in range(n):
            while stack and stack[-1] > num[i] and k != 0:
                stack.pop()
                k -= 1
            stack.append(num[i])
        
        

        while k > 0:
            stack.pop()
            k -= 1
        stack = stack[::-1]
        while stack and len(stack) > 1 and stack[-1] == "0":
            stack.pop()
        stack = stack[::-1]
        return "".join(stack)