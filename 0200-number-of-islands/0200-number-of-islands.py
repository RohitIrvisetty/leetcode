class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid: return 0
        count = 0
        rows = len(grid)
        columns = len(grid[0])
        visited = [[False for _ in range(columns)] for _ in range(rows)]
        stack = []
        
        for i in range(rows):
            for j in range(columns):
                if (not visited[i][j]) and grid[i][j] == '1':
                    stack.append((i, j))
                    
                    count += 1
                    
                    #DFS
                    while stack:
                        r, c = stack.pop()
                        if not visited[r][c] and grid[r][c] == '1':
                            visited[r][c] = True
                            if r - 1 >= 0:
                                stack.append((r - 1, c))
                            if r + 1 < rows:
                                stack.append((r + 1, c))
                            if c - 1 >= 0:
                                stack.append((r, c - 1))
                            if c + 1 < columns:
                                stack.append((r, c + 1))

        return count


        # if not grid: return 0
        # r, c = len(grid), len(grid[0])
        # visited = [[False for _ in range(c)] for _ in range(r)]

        # def dfs(i, j):
        #     if i < 0 or i >= r or j < 0 or j >= c or grid[i][j] == '0' or visited[i][j]:
        #         return
        #     visited[i][j] = True
        #     dfs(i + 1, j)
        #     dfs(i - 1, j)
        #     dfs(i, j + 1)
        #     dfs(i, j - 1)

        # count = 0
        # for i in range(r):
        #     for j in range(c):
        #         if not visited[i][j] and grid[i][j] == '1':
        #             dfs(i, j)
        #             count += 1
        # return count