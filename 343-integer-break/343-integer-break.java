class Solution {
    // int ans=0;
    public int integerBreak(int n) {
        if(n==2) return 1;
        int arr[]=new int[n-1];
        int len=arr.length;
        int dp[][]=new int[len][n+1];
        for(int i=0; i<len; i++) arr[i]=i+1;
        
        for(int i=0; i<len; i++) dp[i][0]=1;
        for(int idx=1; idx<len; idx++){
            for(int k=1; k<=n; k++){
                int left=1,right=1;
                if(arr[idx]<=k) left=arr[idx]*dp[idx][k-arr[idx]];
                right=dp[idx-1][k];
                dp[idx][k]=Math.max(left,right);
            }
        }
        return dp[n-2][n];
    }
}