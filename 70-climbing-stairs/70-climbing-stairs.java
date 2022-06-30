class Solution {
    int dp[]=new int[46];
    // Arrays.fill(dp,-1);
    public int climbStairs(int n) {
       if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n]!=0) return dp[n];
        
        int val=climbStairs(n-1)+ climbStairs(n-2);
        dp[n]=val;
        return val;
    }
}