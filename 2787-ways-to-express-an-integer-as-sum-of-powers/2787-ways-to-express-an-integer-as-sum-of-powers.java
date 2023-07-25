class Solution {
    int dp[][]=new int[500][500];
    int MOD=(int)1e9+7;
    public int numberOfWays(int n, int x) {
        for(int arr[]:dp)Arrays.fill(arr,-1);
        return helper(n,x,1);
    }
    
    int helper(int n,int x,int number){
        if(n<0) return 0;
        else if(n==0) return 1;
        else if(number>300) return 0;

        
        if(dp[number][n]!=-1) return dp[number][n];
        int take=(helper(n-(int)Math.pow(number,x),x,number+1)%MOD);
        int nottake=helper(n,x,number+1)%MOD;
        
        return dp[number][n]=(take+nottake)%MOD;
        
    }
    
}