class Solution {
    private final int infinity = Integer.MAX_VALUE;
    private int max_rows = 0;
    private int max_cols = 0;

    public void wallsAndGates(int[][] rooms) {
        this.max_rows = rooms.length;
        this.max_cols = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < max_rows; i++) {
            for (int j = 0; j < max_cols; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i, j, 0});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] currCell = queue.poll();
            int row = currCell[0];
            int col = currCell[1];
            int steps = currCell[2];

            rooms[row][col] = steps;

            if (row > 0 && rooms[row - 1][col] != -1 && rooms[row - 1][col] != 0 && rooms[row - 1][col] == 2147483647) {
                rooms[row - 1][col] = steps + 1;
                queue.offer(new int[] {row - 1, col, steps + 1});
            }

            if (row < max_rows - 1 && rooms[row + 1][col] != -1 && rooms[row + 1][col] != 0 && rooms[row + 1][col] == 2147483647) {
                rooms[row + 1][col] = steps + 1;
                queue.offer(new int[] {row + 1, col, steps + 1});
            }

            if (col > 0 && rooms[row][col - 1] != -1 && rooms[row][col - 1] != 0 && rooms[row][col - 1] == 2147483647) {
                rooms[row][col - 1] = steps + 1;
                queue.offer(new int[] {row, col - 1, steps + 1});
            }

            if (col < max_cols - 1 && rooms[row][col + 1] != -1 && rooms[row][col + 1] != 0 && rooms[row][col + 1] == 2147483647) {
                rooms[row][col + 1] = steps + 1;
                queue.offer(new int[] {row, col + 1, steps + 1});
            }
        }

    }
}