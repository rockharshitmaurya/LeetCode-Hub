class Solution {
    int grid[][],dp[][][];
    int mod=(int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        grid=new int[m][n];
        dp=new int[m][n][maxMove+1];
        for(int arr2[][]:dp) 
            for(int arr[]:arr2)
                Arrays.fill(arr,-1);
        
       
        int res=helper(startRow,startColumn,maxMove);
         // for(int num[]:dp){
         //    for(int ni:num)
         //        System.out.print(ni+" ");
         //     System.out.println();
         // }
        return res;
    }
    int helper(int i,int j,int maxMove){
        if((i<0 || i==grid.length || j<0 || j==grid[0].length) && maxMove>=0) return 1;
        if(maxMove==0) return 0;
        if(dp[i][j][maxMove]!=-1) return dp[i][j][maxMove];
        long a=helper(i,j+1,maxMove-1);
        long b=helper(i,j-1,maxMove-1);
        long c=helper(i+1,j,maxMove-1);
        long d=helper(i-1,j,maxMove-1);
        return dp[i][j][maxMove]=(int)((a+b+c+d)%mod);
    }
}