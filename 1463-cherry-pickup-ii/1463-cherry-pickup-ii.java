class Solution {
    public int cherryPickup(int[][] grid) {
        
        //recursion + memoization
        
        int row=grid.length,col=grid[0].length;
        int dp[][][]=new int[row][col][col];
        for(int arr[][]:dp)
            for(int arr1[]:arr) 
                Arrays.fill(arr1,-1);
       return helper(grid,0,0,grid[0].length-1,grid[0].length,dp); 
    }
    int helper(int grid[][],int row,int col1,int col2,int len,int dp[][][]){
        if(col1<0 || col2<0 || col1>=len || col2>=len) return (int)-1e8;
        if(row==grid.length-1){
                if(col1==col2) return grid[row][col1];
                else return grid[row][col1]+grid[row][col2];
        }
        if(dp[row][col1][col2]!=-1) return dp[row][col1][col2];
        int min=(int)-1e8;
        for(int dj1=-1; dj1<=1; dj1++){
            for(int dj2=-1; dj2<=1; dj2++){
                int val=0;
                if(col1==col2) val=grid[row][col1];
                else val=grid[row][col1]+grid[row][col2];
                val+=helper(grid,row+1,col1+dj1,col2+dj2,len,dp);
                min=Math.max(min,val);
            }
        }
        return dp[row][col1][col2]=min;
    }
}