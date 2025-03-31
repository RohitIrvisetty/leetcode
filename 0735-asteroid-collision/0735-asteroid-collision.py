class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for asteroid in asteroids:
            flag = True
            while stack and asteroid < 0 and stack[-1] > 0:
                if abs(stack[-1]) == abs(asteroid):  
                    stack.pop()  
                    flag = False
                    break
                elif abs(asteroid) > abs(stack[-1]):
                    stack.pop()
                else:
                    flag = False
                    break
            if flag:
                stack.append(asteroid)
        return stack