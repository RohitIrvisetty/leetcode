class Solution:
    def isHappy(self, n: int) -> bool:
        if n == 1:
            return True
        def get_next(number):
            return sum(int(digit) ** 2 for digit in str(number))
        
        seen = set()
        slow = n
        fast = get_next(n)
        while fast != 1 and slow != fast:
            fast = get_next(get_next(fast))
            slow = get_next(slow)
        
        return fast == 1     