class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean dp[]=new boolean[n];
        dp[n-1]=true;
        
        for(int idx=n-2; idx>=0; idx--){
            boolean jump=false; 
            if(nums[idx]==0) continue;
            for(int i=idx+1; i<=Math.min((idx+nums[idx]),n-1); i++)
                jump|=dp[i];
            dp[idx]=jump;
        }
        
        return dp[0];
    }
    
    boolean helper(int nums[],int idx){
        if(idx==nums.length-1) return true;
        if(idx>=nums.length) return false;
        if(nums[idx]==0) return false;
        boolean jump=false;
        
        for(int i=idx+1; i<=(idx+nums[idx]); i++)
            jump|=helper(nums,i);
        return jump;
    }
}