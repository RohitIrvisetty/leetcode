class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int targetRow = m - 1, targetCol = 0;

        while (targetRow >= 0 && targetCol < n) {
            if (matrix[targetRow][targetCol] == target) {
                return true;
            }

            if (matrix[targetRow][targetCol] > target) {
                targetRow--;
            } else {
                targetCol++;
            }
        }

        return false;
    }
}