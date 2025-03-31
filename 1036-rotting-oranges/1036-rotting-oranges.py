from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return -1
    
        rows, cols = len(grid), len(grid[0])
        queue = deque()
        fresh_count = 0
        
        # Initialize the queue with all rotten oranges' positions and count fresh oranges
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    queue.append((r, c, 0))  # (row, col, minute)
                elif grid[r][c] == 1:
                    fresh_count += 1
        
        # Directions for 4-way adjacency
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        minutes_elapsed = 0
        
        while queue:
            r, c, minutes = queue.popleft()
            minutes_elapsed = max(minutes_elapsed, minutes)
        
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == 1:
                    grid[nr][nc] = 2  # Make it rotten
                    queue.append((nr, nc, minutes + 1))
                    fresh_count -= 1
        # If there are still fresh oranges left, return -1
        return minutes_elapsed if fresh_count == 0 else -1