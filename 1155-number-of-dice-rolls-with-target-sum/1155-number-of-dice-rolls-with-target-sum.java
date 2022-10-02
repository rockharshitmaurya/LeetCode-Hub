class Solution {
    int mod=(int)1e9+7;
    int dp[][];
    public int numRollsToTarget(int n1, int k, int tar) {
        dp=new int[n1+1][tar+1];
        // for(int i=0; i<dp.length; i++){
        //     dp[i][0]=1;
        // }
        dp[0][0]=1;
        
        for(int n=1; n<=n1; n++){
            for(int target=1; target<=tar; target++){
                int count=0;
                for(int i=1; i<=k; i++){
                    if(i<=target) count=(count+dp[n-1][target-i])%mod;
                }
                dp[n][target]=count;
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[n1][tar];
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