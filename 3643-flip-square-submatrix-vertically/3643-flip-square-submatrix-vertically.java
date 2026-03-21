class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int rows = grid.length;
        int columns = grid[0].length;

        int top = x, bottom = x + k - 1;

        while (top < bottom) {
            swap(grid, top, bottom, y, y + k - 1);
            top++;
            bottom--;
        }

        return grid;
    }

    private void swap(int[][] grid, int top, int bottom, int col1, int col2) {

        if (top == bottom) return;
        System.out.println(top + " " + bottom + " " + col1 + " " + col2);
        for (int i = col1; i <= col2; i++) {
            System.out.println(i + " " + grid[top][i] + " " + grid[bottom][i]);
            grid[top][i] = grid[top][i] ^ grid[bottom][i];
            grid[bottom][i] = grid[top][i] ^ grid[bottom][i];
            grid[top][i] = grid[top][i] ^ grid[bottom][i];
            System.out.println(i + " " + grid[top][i] + " " + grid[bottom][i]);
        }
    }
}