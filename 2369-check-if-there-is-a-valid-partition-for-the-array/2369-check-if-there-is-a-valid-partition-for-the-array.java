class Solution {
    public boolean validPartition(int[] nums) {
        int n=nums.length;
        boolean dp[]=new boolean[n*2];
        dp[n]=true;
        for(int i=n-1; i>=0; i--){
            // for(int i=idx; i<n; i++){
                boolean or=false;
                if(i+1<n && nums[i]==nums[i+1])
                    or|=dp[i+2];
                if(i+2<n && nums[i]==nums[i+1] && nums[i]==nums[i+2])
                    or|=dp[i+3];  
                if(i+2<n && nums[i]+1==nums[i+1] && nums[i]+2==nums[i+2])
                    or|=dp[i+3];  
                dp[i] =  or;
            // }
        }
        return dp[0];
    }
}