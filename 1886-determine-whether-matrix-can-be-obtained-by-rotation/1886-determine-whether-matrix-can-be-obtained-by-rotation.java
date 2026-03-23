class Solution {

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        // at most 4 rotations
        for (int k = 0; k < 4; k++) {
            // rotation operation
            for (int layer = 0; layer < n / 2; layer++) {
                int first = layer;
                int last = n - 1 - layer;

                for (int i = first; i < last; i++) {
                    int top = mat[first][i];

                    int right = mat[i][last];

                    int bottom = mat[last][n - 1 - i];

                    int left = mat[n - 1 - i][first];
                    
                    // left -> top
                    mat[first][i] = mat[n - 1 - i][first];
                    
                    // bottom -> left
                    mat[n - 1 - i][first] = mat[last][n - 1 - i];

                    // right -> bottom
                    mat[last][n - 1 - i] = mat[i][last];

                    // top -> right
                    mat[i][last] = top;                    
                }

            }

            if (isEqual(mat, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}