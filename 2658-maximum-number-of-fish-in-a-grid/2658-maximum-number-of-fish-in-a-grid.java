class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxFish = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    int fish = dfs(grid, visited, i, j);
                    maxFish = Math.max(maxFish, fish);
                }
            }
        }
        return maxFish;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        int fish = 0;
        int[][] directions = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        visited[row][col] = true;
        fish += grid[row][col];

        for (int[] direction: directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] == 0 || visited[newRow][newCol]) {
                continue;
            }

            fish += dfs(grid, visited, newRow, newCol);
        }
        return fish;
    }
}