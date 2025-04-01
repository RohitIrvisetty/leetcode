class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        row = 0
        column = n - 1

        while column >= 0 and row < m:
            if matrix[row][column] == target:
                return True
            elif matrix[row][column] < target:
                row = row + 1
            else:
                column = column - 1
        return False