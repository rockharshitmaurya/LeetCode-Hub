class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[]=new int[target+1];
        dp[0]=1;
        for(int tgt=0; tgt<=target; tgt++){
            for(int idx=nums.length-1; idx>=0; idx--){
                int take=0;
                if(tgt>=nums[idx]) take = dp[tgt-nums[idx]];
                int nottake=dp[tgt];
                dp[tgt]=take+nottake;
            }
        }
        return dp[target];
    }
}