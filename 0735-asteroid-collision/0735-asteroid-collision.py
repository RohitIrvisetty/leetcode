class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
    
        for asteroid in asteroids:
            flag = True
            while stack and asteroid < 0 and stack[-1] > 0:  # Collision condition

                if abs(stack[-1]) < abs(asteroid):  
                    stack.pop()
                    continue 

                elif abs(stack[-1]) == abs(asteroid):  
                    stack.pop()  

                flag = False
                break
            
            if flag:
                stack.append(asteroid)  # No collision, push to stack

        return stack