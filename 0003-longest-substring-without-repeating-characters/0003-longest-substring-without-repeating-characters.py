class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_index = {}  # Stores the index of characters
        max_length = 0
        l = 0  # Left pointer

        for r, char in enumerate(s):  # Right pointer moves forward
            if char in char_index and char_index[char] >= l:
                l = char_index[char] + 1  # Jump past the last occurrence
            
            char_index[char] = r  # Update latest index of char
            max_length = max(max_length, r - l + 1)  # Calculate max length

        return max_length