class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int minutes = 0;
        int freshOranges = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rottenQueue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        int[][] directions = {{-1, 0},
                                {1, 0},
                                {0, -1},
                                {0, 1}};

        while (!rottenQueue.isEmpty()) {
            int currQueueSize = rottenQueue.size();
            minutes++;
            System.out.println(rottenQueue.peek()[1]);
            while (currQueueSize-- > 0) {
                int[] currCell = rottenQueue.poll();

                int row = currCell[0];
                int col = currCell[1];

                for (int i = 0; i < directions.length; i++) {
                    int newRow = row + directions[i][0];
                    int newCol = col + directions[i][1];

                    if (newRow >= 0 && newRow < m &&
                        newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == 1) {
                            grid[newRow][newCol] = 2;
                            freshOranges--;
                            rottenQueue.offer(new int[] {newRow, newCol});
                        }
                }
            }
        }
        return freshOranges > 0? -1: minutes - 1;
    }
}