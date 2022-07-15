class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        dp=new int[nums.length][nums.length+1];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        return helper(nums,0,-1);
    }
    int helper(int nums[],int idx,int prev){
        if(idx==nums.length){
            return 0;
        }
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int pick=0;
        if(prev==-1 || nums[idx]>nums[prev]){
            pick=1+helper(nums,idx+1,idx);
        }
        int notpick=helper(nums,idx+1,prev);
        return dp[idx][prev+1]=Math.max(pick,notpick);
    }
}