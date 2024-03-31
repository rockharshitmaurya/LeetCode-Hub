class Solution {

    public int uniquePathsIII(int[][] grid) {
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1) return helper(grid,i,j);
            }
        }
        
        return 0;
    }

    int helper(int grid[][], int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == -1) return 0;
        if (grid[i][j] == 2) {
            if (ok(grid)) return 1; else return 0;
        }

        int dirs[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int score = 0;
        grid[i][j] = -1;
        for (int arr[] : dirs) {
            int newx = i + arr[0];
            int newy = j + arr[1];
            score += helper(grid, newx, newy);
        }
        grid[i][j] = 0;
        return score;
    }

    boolean ok(int grid[][]) {
        for (int arr[] : grid) {
            for (int num : arr) {
                if (num == 0) return false;
            }
        }

        return true;
    }
}
