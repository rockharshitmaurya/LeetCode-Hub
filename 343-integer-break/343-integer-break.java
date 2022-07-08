class Solution {
    int ans=0;
    public int integerBreak(int n) {        
        int arr[]=new int[n-1];
        int dp[][]=new int[n][n+1];
        for(int sub[]:dp) Arrays.fill(sub,-1);
        for(int i=0; i<n-1; i++) arr[i]=i+1;
        ans=helper(n-2,arr,n,1,dp);
        return ans;
    }
    int  helper(int idx,int arr[],int n,int pro,int dp[][]){
        if(idx==-1) return 0;
        if(n==0) return 1;
        if(dp[idx][n]!=-1) return dp[idx][n];
        int left=1,right=1;
        if(arr[idx]<=n) left=arr[idx]*helper(idx,arr,n-arr[idx],pro*arr[idx],dp);
        right=helper(idx-1,arr,n,pro,dp);
        return dp[idx][n]=Math.max(left,right);
    }
}