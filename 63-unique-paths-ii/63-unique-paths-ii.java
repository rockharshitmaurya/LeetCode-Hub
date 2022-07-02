class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        int m=og.length,n=og[0].length;
        if(og[m-1][n-1]==1 || og[0][0]==1) return 0;
        int dp[][]=new int[m][n]; 
        // dp[0][0]=1;
        // for(int i=1; i<n; i++) dp[0][i]=og[0][i]==1?0:dp[0][i-1];
        // for(int i=1; i<m; i++) dp[i][0]=og[i][0]==1?0:dp[i-1][0];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) dp[i][j]=1;
                else if(og[i][j]==1) dp[i][j]=0;
                else{
                    int up=0,left=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}