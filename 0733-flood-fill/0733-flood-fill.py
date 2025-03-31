class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m = len(image)
        n = len(image[0])
        visited = [[False for _ in range(n)] for _ in range(m)]
        result = [[image[r][c] for c in range(n)] for r in range(m)]
        stack = [(image[sr][sc], sr, sc)]
        color_init = image[sr][sc]
        
        while stack:
            node, row, col = stack.pop()
            if not visited[row][col] and result[row][col] == color_init:
                result[row][col] = color
                visited[row][col] = True

                if row - 1 >= 0:
                    stack.append((image[row][col], row - 1, col))

                if row + 1 < m:
                    stack.append((image[row][col], row + 1, col))
                
                if col - 1 >= 0:
                    stack.append((image[row][col - 1], row, col - 1))

                if col + 1 < n:
                    stack.append((image[row][col + 1], row, col + 1))
        
        return result
        