class Solution:
    def isHappy(self, n: int) -> bool:
        if n == 1:
            return True
        

        def get_next(number):
            return sum(int(digit) ** 2 for digit in str(number))
        
        seen = set()
        
        while n != 1 and n not in seen:
            seen.add(n)
            n = get_next(n)
        
        return n == 1        