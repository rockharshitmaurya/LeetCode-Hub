class Solution {
    int dp[];
    public int minCost(int[] nums, int k) {
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(nums,k,0);
    }
    
    int helper(int nums[],int k,int idx){
        if(idx==nums.length) return 0;
        
        if(dp[idx]!=-1) return dp[idx];
        int freq[]=new int[nums.length];
        int ans=(k+nums.length);
        int count=0;
        
        for(int i=idx; i<nums.length; i++){
            freq[nums[i]]++;
            if (freq[nums[i]] == 2) {
                count += 2;
            }
            else if (freq[nums[i]] > 2) {
                count += 1;
            }
            ans=Math.min(ans,count+k+helper(nums,k,i+1));
        }
        return dp[idx]=ans;
    }
}