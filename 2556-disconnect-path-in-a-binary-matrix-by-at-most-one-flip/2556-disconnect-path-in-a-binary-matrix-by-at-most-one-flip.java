class Solution {
    int dirs[][] = { { 1, 0 }, { 0, 1 } };

    public boolean isPossibleToCutPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean first = dfs(grid, 0, 0);
        if (!first) return true;
        grid[n - 1][m - 1] = 1;
        boolean second = dfs(grid, 0, 0);
        return !second;
    }

    boolean dfs(int grid[][], int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) return true;
        grid[i][j] = 0;
        for (int arr[] : dirs) {
            int row = arr[0] + i, col = arr[1] + j;
            if (row == grid.length || col == grid[0].length || grid[row][col] == 0) continue;

            if (dfs(grid, row, col)) {
                
                return true;
            }
        }
        return false;
    }
}
