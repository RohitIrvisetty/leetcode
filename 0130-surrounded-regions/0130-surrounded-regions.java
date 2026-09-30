class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] != 'X') {
                dfs(board, i, 0, m, n);
            }

            if (board[i][n - 1] != 'X') {
                dfs(board, i, n - 1, m, n);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] != 'X') {
                dfs(board, 0, j, m , n);
            }

            if (board[m - 1][j] != 'X') {
                dfs(board, m - 1, j, m, n);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'M') {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col, int m, int n) {
        board[row][col] = 'M';

        if (row > 0 && board[row - 1][col] != 'X' && board[row - 1][col] != 'M') {
            dfs(board, row - 1, col, m , n);
        }

        if (row < m - 1 && board[row + 1][col] != 'X' && board[row + 1][col] != 'M') {
            dfs(board, row + 1, col, m , n);
        }

        if (col > 0 && board[row][col - 1] != 'X' && board[row][col - 1] != 'M') {
            dfs(board, row, col - 1, m, n);
        }

        if (col < n - 1 && board[row][col + 1] != 'X' && board[row][col + 1] != 'M') {
            dfs(board, row, col + 1, m, n);
        }
    }
}