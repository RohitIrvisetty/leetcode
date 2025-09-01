class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        stack = []
        seen = set()
        freq = {char: s.count(char) for char in s}
    
        for char in s:
            # Decrement frequency count for this character
            freq[char] -= 1
        
            # If character is already in the stack, skip it
            if char in seen:
                continue
        
            # Remove characters that are greater than current and appear later
            while stack and char < stack[-1] and freq[stack[-1]] > 0:
                removed = stack.pop()
                seen.remove(removed)
        
            # Add the current character to the stack and mark it as seen
            stack.append(char)
            seen.add(char)
    
        # Convert the stack to a string and return
        return ''.join(stack)