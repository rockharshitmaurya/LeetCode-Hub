class Solution {
    int dp[][][];
    int mod=(int)1e9+7;
    public int numberOfPaths(int[][] grid, int k) {
        int n=grid.length,m=grid[0].length;
        dp=new int[n][m][k+1];
        
        for(int arr[][]:dp){
            for(int sub[]:arr){
                Arrays.fill(sub,-1);
            }
        }
        return helper(grid,0,0,0,k);
    }
    
    int helper(int grid[][],int i,int j,int sum,int k){
        if(i==grid.length || j==grid[0].length) return 0;
        sum = sum + grid[i][j];
        
        if(i==grid.length-1 && j==grid[0].length-1) return sum%k==0?1:0;
        
        if(dp[i][j][sum%k]!=-1) return dp[i][j][sum%k];
            
            
        return dp[i][j][sum%k]=(helper(grid,i+1,j,sum,k) +  helper(grid,i,j+1,sum,k)) % mod;
    }
}