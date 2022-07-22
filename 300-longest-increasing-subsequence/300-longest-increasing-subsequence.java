class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int sub[]:dp) Arrays.fill(sub,-1);
        return helper(nums,0,-1,dp);
    }
    int helper(int nums[],int idx,int prev,int dp[][]){
        if(idx==nums.length){
            return 0;
        }
        
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int pick=0;
        if(prev==-1 || nums[idx]>nums[prev]) pick=1+helper(nums,idx+1,idx,dp);
        int notpick=helper(nums,idx+1,prev,dp);
        
        return dp[idx][prev+1]=Math.max(pick,notpick);
    }
}