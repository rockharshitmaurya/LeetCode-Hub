class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int first[]=new int[n-1];
        int last[]=new int[n-1];
        for(int i=0; i<n; i++){
            if(i!=0) first[i-1]=nums[i];
            if(i!=n-1) last[i]=nums[i];
        }
        return Math.max(helper(first,n-1),helper(last,n-1));
        
    }
    int helper(int nums[],int n){
        int dp[]=new int[n];
        dp[0]=nums[0];
        for(int i=1; i<n; i++){
            int take=nums[i]+((i>1)?dp[i-2]:0);
            int notTake=0+dp[i-1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[n-1];
    }
}