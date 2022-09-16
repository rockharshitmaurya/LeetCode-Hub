class Solution {
    Integer dp[][];
    public int maximumScore(int[] nums, int[] multipliers) {
        int m=multipliers.length;
        dp=new Integer[m][m];
        return helper(nums,multipliers,0,nums.length-1,0);
    }
    
    int helper(int nums[],int multi[],int left,int right,int idx){
        if(idx==multi.length) return 0;
        if(dp[left][idx]!=null) return dp[left][idx];
        int front=nums[left]*multi[idx]+
                    helper(nums,multi,left+1,right,idx+1);
        int end=nums[right]*multi[idx]+
                    helper(nums,multi,left,right-1,idx+1);
        return dp[left][idx]=Math.max(front,end);
    }
}
