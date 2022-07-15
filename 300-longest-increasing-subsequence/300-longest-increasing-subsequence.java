class Solution {
    
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
       int dp[][]=new int[n+1][n+1];
        for(int idx=n-1; idx>=0; idx--){
            for(int prev=idx-1; prev>=-1; prev--){
                int pick=0;
                if(prev==-1 || nums[idx]>nums[prev]){
                   pick=1+dp[idx+1][idx+1];
                }
                int notpick=dp[idx+1][prev+1];
                dp[idx][prev+1]=Math.max(pick,notpick);
            }
        }
        return dp[0][0];
    }
    // int helper(int nums[],int idx,int prev){
    //     if(idx==nums.length){
    //         return 0;
    //     }
    //     if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
    //     int pick=0;
    //     if(prev==-1 || nums[idx]>nums[prev]){
    //         pick=1+helper(nums,idx+1,idx);
    //     }
    //     int notpick=helper(nums,idx+1,prev);
    //     return dp[idx][prev+1]=Math.max(pick,notpick);
    // }
}