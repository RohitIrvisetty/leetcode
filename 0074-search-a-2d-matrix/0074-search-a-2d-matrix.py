class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        left = 0
        right = m * n - 1

        while left <= right:
            mid = (left + right) // 2

            row = mid // n
            column = mid % n
            print(mid, row, column)
            if matrix[row][column] == target:
                return True
            elif matrix[row][column] < target:
                left = mid + 1
            else:
                right = mid - 1
            
        return False