import java.util.*;

class Solution {

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Set<String> distinctIslands = new HashSet<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 1) {

                    // Starting point of this island
                    int baseRow = row;
                    int baseCol = col;

                    List<String> shape = new ArrayList<>();

                    dfs(grid, row, col, baseRow, baseCol, shape);

                    // Same-shaped islands will produce the same representation
                    System.out.println(String.join(",", shape));
                    distinctIslands.add(String.join(",", shape));
                }
            }
        }

        return distinctIslands.size();
    }

    private void dfs(
            int[][] grid,
            int row,
            int col,
            int baseRow,
            int baseCol,
            List<String> shape) {

        int m = grid.length;
        int n = grid[0].length;

        // Boundary / visited / water check
        if (row < 0 || row >= m ||
            col < 0 || col >= n ||
            grid[row][col] == 0) {
            return;
        }

        // Mark visited
        grid[row][col] = 0;

        // Store position relative to the island's starting cell
        shape.add((row - baseRow) + "." + (col - baseCol));

        dfs(grid, row + 1, col, baseRow, baseCol, shape);
        dfs(grid, row - 1, col, baseRow, baseCol, shape);
        dfs(grid, row, col + 1, baseRow, baseCol, shape);
        dfs(grid, row, col - 1, baseRow, baseCol, shape);
    }
}