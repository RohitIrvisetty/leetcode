class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if token in ["+", "-", "*", "/"]:
                num1 = stack.pop()
                num2 = stack.pop()
                ans = 0
                if token == "+":
                    ans = num2 + num1
                elif token == "-":
                    ans = num2 - num1
                elif token == "*":
                    ans = num2 * num1
                else:
                    ans = num2 / num1
                stack.append(int(ans))
            else:
                stack.append(int(token))
        
        return int(stack[-1])