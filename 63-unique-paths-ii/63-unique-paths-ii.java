class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        int m=og.length,n=og[0].length;
        if(og[m-1][n-1]==1 || og[0][0]==1) return 0;
        int dp[][]=new int[m][n]; dp[0][0]=1;
        for(int i=1; i<n; i++) dp[0][i]=og[0][i]==1?0:dp[0][i-1];
        for(int i=1; i<m; i++) dp[i][0]=og[i][0]==1?0:dp[i-1][0];
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j]=og[i][j]==0?(dp[i-1][j]+dp[i][j-1]):0;
            }
        }
        for(int arr[]:dp)
            System.out.println(Arrays.toString(arr));
        return dp[m-1][n-1];
    }
     int helper(int grid[][],int row,int col,int memo[][]){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0 || grid[row][col]==1) return 0;
        if(memo[row][col]!=-1) return memo[row][col];
        int l=helper(grid,row-1,col,memo);
        int r=helper(grid,row,col-1,memo);
        memo[row][col]=l+r;
        return l+r;
    }
}