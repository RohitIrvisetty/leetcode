class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        M = len(grid)
        N = len(grid[0])
        def search(arr):
            left, right = 0, len(arr) - 1
            while left<=right:
                mid = (left+right)//2
                if arr[mid]>=0:
                    left = mid+1
                else:
                    right = mid-1
            return left
        count = 0
        for row in grid:
            count+=(N-search(row))
        return count