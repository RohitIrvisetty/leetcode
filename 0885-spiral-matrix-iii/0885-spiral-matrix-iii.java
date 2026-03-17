class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int totalCellCount = rows * cols;
        int count = 0, step = 1;
        int[][] movement = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;

        while (count < totalCellCount) {

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < step; j++) {

                    if (rStart >=0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        res[count][0] = rStart;
                        res[count][1] = cStart;
                        count++;
                    }

                    rStart += movement[direction][0];
                    cStart += movement[direction][1];
                }
                direction = (direction + 1) % 4;
            }
            step++;
        }

        return res;
    }
}