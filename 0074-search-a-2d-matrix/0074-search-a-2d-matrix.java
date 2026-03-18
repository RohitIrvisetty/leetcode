class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int totalElements = numRows * numCols;

        int left = 0, right = totalElements - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midRow = mid / numCols;
            int midCol = mid % numCols;
            int midELe = matrix[midRow][midCol];
            if (midELe == target) {
                return true;
            }

            if (midELe > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}