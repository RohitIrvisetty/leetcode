class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(n):
            for j in range(i+1, n):
                matrix[j][i], matrix[i][j] = matrix[i][j], matrix[j][i]
        
        for i in range(n):
            for j in range(n // 2):
                print(i, j)
                matrix[i][j], matrix[i][-j - 1] = matrix[i][-j - 1], matrix[i][j]
        return matrix