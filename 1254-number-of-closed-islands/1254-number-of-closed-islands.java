class Solution {

    public int closedIsland(int[][] grid) {
        return solve(grid);
    }

    public int solve(int[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 0) dfs(board, i, 0);
            if (board[i][m - 1] == 0) dfs(board, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 0) dfs(board,  0, i);
            if (board[n - 1][i] == 0) dfs(board, n - 1, i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 ) {
                    dfs(board,i,j); ans++;
                }
            }
        }
        return ans;
    }

    void dfs(int board[][], int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == 1) return;
        board[i][j]=1;
        dfs(board, i + 1, j);
        dfs(board,  i - 1, j);
        dfs(board,  i, j + 1);
        dfs(board,  i, j - 1);
    }
}
