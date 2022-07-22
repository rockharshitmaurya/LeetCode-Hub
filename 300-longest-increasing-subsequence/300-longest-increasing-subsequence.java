class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length];
        int hash[]=new int[nums.length];
        Arrays.fill(dp,1); int ans=0;
        int last_idx=0;
        for(int i=0; i<nums.length; i++){
            hash[i]=i;
            for(int j=i-1; j>=0; j--){
                if(nums[j]<nums[i] && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>ans){
                ans=dp[i];
                last_idx=i;
            }
        }
        // String res="";
        // while(hash[last_idx]!=last_idx){
        //     res=nums[last_idx]+" "+res;
        //     last_idx=hash[last_idx];
        //     // System.out.println("IN");
        // }
        // System.out.println(nums[last_idx]+" "+res);
        return ans;
    }
}