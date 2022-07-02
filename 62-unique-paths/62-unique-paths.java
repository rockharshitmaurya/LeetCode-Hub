class Solution {
    public int uniquePaths(int m, int n) {
        int memo[][]=new int[m][n];
        for(int arr[]:memo)
            Arrays.fill(arr,-1);
        return helper(new int[m][n],m-1,n-1,memo);
    }
    int helper(int grid[][],int row,int col,int memo[][]){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==1) return 0;
        if(memo[row][col]!=-1) return memo[row][col];
        grid[row][col]=1;
        int l=helper(grid,row-1,col,memo);
        int r=helper(grid,row,col-1,memo);
        grid[row][col]=0;
        memo[row][col]=l+r;
        return l+r;
    }
}