class Solution:
    def nextGreaterElement(self, n: int) -> int:
        digits = list(str(n))  # Convert number to a list of digits
        length = len(digits)

        # Step 1: Find first decreasing digit from the right
        i = length - 2
        while i >= 0 and digits[i] >= digits[i + 1]:
            i -= 1
        
        if i == -1:  # No larger permutation possible
            return -1

        # Step 2: Find the smallest digit greater than digits[i] on the right
        j = length - 1
        while digits[j] <= digits[i]:
            j -= 1

        # Step 3: Swap digits[i] and digits[j]
        digits[i], digits[j] = digits[j], digits[i]

        # Step 4: Reverse the suffix to get the next smallest number
        digits[i + 1:] = reversed(digits[i + 1:])

        # Step 5: Convert back to integer
        result = int("".join(digits))

        # Step 6: Check if the result is within 32-bit signed integer range
        return result if result <= (2**31 - 1) else -1