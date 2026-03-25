class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = 0;
        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }

        // If total is odd, cannot split equally
        if (total % 2 != 0)
            return false;

        long target = total / 2;

        // Check horizontal cuts
        long topSum = 0;
        for (int i = 0; i < m - 1; i++) { // ensure bottom part is non-empty
            for (int j = 0; j < n; j++) {
                topSum += grid[i][j];
            }
            if (topSum == target)
                return true;
        }

        // Check vertical cuts
        long leftSum = 0;
        for (int j = 0; j < n - 1; j++) { // ensure right part is non-empty
            for (int i = 0; i < m; i++) {
                leftSum += grid[i][j];
            }
            if (leftSum == target)
                return true;
        }

        return false;
    }
}