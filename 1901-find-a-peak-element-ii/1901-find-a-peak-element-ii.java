class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int left = 0, right = m - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int maxCol = 0;

            for (int i = 0; i < n; i++) {
                if (mat[mid][i] > mat[mid][maxCol]) {
                    maxCol = i;
                }
            }

            int leftNeighbor = (mid - 1 >= 0)? mat[mid - 1][maxCol]: -1;
            int rightNeighbor = (mid + 1 < m)? mat[mid + 1][maxCol]: -1;

            if (mat[mid][maxCol] > leftNeighbor && mat[mid][maxCol] > rightNeighbor) {
                return new int[] {mid, maxCol};
            }

            if (mat[mid][maxCol] < leftNeighbor) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return new int[] {-1, -1};
    }
}