class Solution:
    def findCircleNum(self, grid: List[List[int]]) -> int:
        if not grid: 
            return 0
        count = 0
        n = len(grid)
        
        visited = [0] * n
        stack = []
        
        for i in range(n):
            
            if (not visited[i]):
                stack.append(i)
                count += 1
                
                #DFS
                while stack:
                    node = stack.pop()
                    for neighbour in range(n):
                        if not visited[neighbour] and grid[node][neighbour] == 1:
                            visited[neighbour] = True
                            stack.append(neighbour)

        return count