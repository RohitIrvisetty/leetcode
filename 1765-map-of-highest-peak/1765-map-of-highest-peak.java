class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        int[][] ans = new int[m][n];
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = 0;

                if (isWater[i][j] == 1) {
                    visited[i][j] = true;
                    queue.offer(new int[] {i, j, 0});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] currCell = queue.poll();
            int row = currCell[0];
            int col = currCell[1];
            int steps = currCell[2];

            for (int[] direction: directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (valid(newRow, newCol, m, n) && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[] {newRow, newCol, steps + 1});
                    ans[newRow][newCol] = steps + 1;
                }
            }
        }
        return ans;
    }

    public boolean valid(int row, int col, int m , int n) {
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}