class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        MOD = 10**9 + 7
        n = len(arr)

        # Arrays to store distances to the previous and next smaller elements
        prev_smaller = [-1] * n
        next_smaller = [n] * n
        MOD = 10**9 + 7
        # Monotonic stack for previous smaller
        stack = []
        for i in range(n):
            while stack and arr[stack[-1]] >= arr[i]:
                stack.pop()
            prev_smaller[i] = stack[-1] if stack else -1
            stack.append(i)
        print(prev_smaller)
        stack = []
        for i in range(n - 1, -1, -1):
            while stack and arr[stack[-1]] > arr[i]:
                stack.pop()
            next_smaller[i] = stack[-1] if stack else n
            stack.append(i)
        print(next_smaller)
        result = 0
        for i in range(n):
            right_count = next_smaller[i] - i
            left_count = i - prev_smaller[i]
            result += right_count * left_count * arr[i]
            
        return result % MOD