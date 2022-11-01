class Solution {
    int extra=0;
    int dp[][];
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp=new int[m][n];
        for(int arr[]:dp)
            Arrays.fill(arr,-1);
        extra=m*2;
        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            int res = helper(grid,0,i,0);
            if(res==-2) ans[i]=-1;
            else ans[i]=res-extra;
        }
        // System.out.println(Arrays.deepToString(grid));
        return ans;
    }
    
    int helper(int grid[][],int i,int j,int start){
        
        if(i==grid.length) return j+extra;
        
        if(dp[i][j]!=-1) return dp[i][j];
        if(grid[i][j]==1){
            int x = i + 1;
            int y = j + 1;   
            if(j+1==grid[0].length || grid[i][j+1]!=grid[i][j]) return -2; 
            dp[i][j]=helper(grid,i+1,j+1,start);
        }else if(grid[i][j]==-1){
            int x = i + 1;
            int y = j - 1;
            if(j-1<0 || grid[i][j-1]!=grid[i][j]) return -2;
            dp[i][j]=helper(grid,i+1,j-1,start);
        }
        
        return dp[i][j];
    }
}



