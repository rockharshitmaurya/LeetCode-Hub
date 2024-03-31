class Solution {
    int mod=(int)1e9+7;
    int dp[][];
    public int numRollsToTarget(int n, int k, int target) {
        dp=new int[n+1][target+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return helper(n,k,target);
    }
    
    
    int helper(int n,int k,int target){
        if(n==0){
            if(target==0) return 1;
            else return 0;
        }
        if(dp[n][target]!=-1) return dp[n][target];
        int count=0;
        for(int i=1; i<=k; i++){
            if(i<=target) count=(count+helper(n-1,k,target-i))%mod;
        }
        
        return dp[n][target]=count;
    }
}