class Solution {
    
    public int maximumScore(int[] nums, int[] multi) {
        int m = multi.length;
        int n = nums.length;
        int dp[][]=new int[m+1][m+1];
        
        
        for(int idx=m-1; idx>=0; idx--){
            for(int left=idx; left>=0; left--){
                int front=nums[left]*multi[idx]+dp[left+1][idx+1];
                int end=nums[n-1-(idx-left)]*multi[idx]+dp[left][idx+1];
                 dp[left][idx]=Math.max(front,end);  
            }
        }
        
        return dp[0][0];
        
    }
    
    // int helper(int nums[],int multi[],int left,int right,int idx){
    //     if(idx==multi.length) return 0;
    //     if(dp[left][idx]!=null) return dp[left][idx];
    //     int front=nums[left]*multi[idx]+
    //                 helper(nums,multi,left+1,right,idx+1);
    //     int end=nums[right]*multi[idx]+
    //                 helper(nums,multi,left,right-1,idx+1);
    //     return dp[left][idx]=Math.max(front,end);
    // }
}
