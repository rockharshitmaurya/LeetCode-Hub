class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        // int dp[][]=new int[n][target+1];
        return helper(nums,n-1,target);
    }
    int helper(int nums[],int idx,int target){
        if(idx<0){
            if(target==0) return 1;
            else return 0;
        }
        
        int left=helper(nums,idx-1,target-nums[idx]);
        int mid=helper(nums,idx-1,target-(-nums[idx]));
        return left+mid;
    }
}