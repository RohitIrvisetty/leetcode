class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // process layer by layer
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int top = matrix[first][i];

                int right = matrix[i][last];

                int bottom = matrix[last][n - 1 - i];

                int left = matrix[n - 1 - i][first];

                // left -> top
                matrix[first][i] = matrix[n - 1 - i][first];

                // bottom -> left
                matrix[n - 1 - i][first] = matrix[last][n - 1 - i];

                // right -> bottom
                matrix[last][n - 1 - i] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }

        }
    }
}