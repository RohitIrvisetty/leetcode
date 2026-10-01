class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0, area = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    area = dfs(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        int area = 1;
        visited[row][col] = true;
        int[][] directions = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        for (int[] direction: directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                continue;
            }

            area += dfs(grid, visited, newRow, newCol);
        }

        return area;
    }
}