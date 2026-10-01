class Solution {
    private int perimeter = 0;
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    this.perimeter += 4;
                    if (i > 0) {
                        this.perimeter -= grid[i - 1][j];
                    }

                    if (i + 1 <= m - 1) {
                        this.perimeter -= grid[i + 1][j];
                    }

                    if (j > 0) {
                        this.perimeter -= grid[i][j - 1];
                    }

                    if (j + 1 <= n - 1) {
                        this.perimeter -= grid[i][j + 1];
                    }
                    dfs(grid, i, j, m, n, visited);
                }
            }
        }
        return this.perimeter;
    }

    private void dfs(int[][] grid, int i, int j, int rows, int cols, boolean[][] visited) {
        if (visited[i][j] || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;

        int[][] directions = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        for (int[] direction: directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];
            int top, bottom, left, right;

            if (newRow < 0 || newRow > rows - 1 || newCol > cols - 1 || newCol < 0) {
                continue;
            }

            if (!visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                //this.perimeter += 4;

                if (newRow - 1 < 0) {top = 0;}
                else {top = grid[newRow - 1][newCol];}

                if (newRow + 1 > rows - 1) {bottom = 0;}
                else {bottom = grid[newRow + 1][newCol];}

                if (newCol - 1 < 0) {left = 0;}
                else {left = grid[newRow][newCol - 1];}

                if (newCol + 1 > cols - 1) {right = 0;}
                else {right = grid[newRow][newCol + 1];}

                this.perimeter += 4 - (top + bottom + left + right);
                dfs(grid, newRow, newCol, rows, cols, visited);
            }
        }
    }
}