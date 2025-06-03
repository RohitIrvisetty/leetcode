class Solution:
    def isPalindrome(self, n: int) -> bool:
        copy = n
        
        # After the code, revNum will
        # contain the reversed number
        revNum = 0

        # Keep on iterating while there
        # are digits left to extract
        while n > 0:
            lastDigit = n % 10

            # Pushing last digit at the
            # back of reversed number
            revNum = (revNum * 10) + lastDigit
            n = n // 10
        
        # Return true if the reversed and 
        # copy of original number is same
        return revNum == copy