class Solution {

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];

        // Create the transpose of the input grid in `result`
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = box[j][i];
            }
        }

        // Reverse each row in the transpose grid to complete the 90° rotation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                char temp = result[i][j];
                result[i][j] = result[i][m - 1 - j];
                result[i][m - 1 - j] = temp;
            }
        }

        for (int i = 0; i < m; i++) {
            int lastEmptyCell = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (result[j][i] == '*') {
                    lastEmptyCell = j - 1;
                } else if (result[j][i] == '#') {
                    result[j][i] = '.';
                    result[lastEmptyCell][i] = '#';
                    lastEmptyCell--;
                }
            }
        }
        return result;
    }
}
