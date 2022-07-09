# Memoization
​
```
class Solution {
public int maxResult(int[] nums, int k) {
int dp[]=new int[nums.length];
Arrays.fill(dp,-1);
return helper(nums,k,0,dp);
}
int helper(int nums[],int k,int idx,int dp[]){
if(idx==nums.length-1){
return nums[idx];
}
if(dp[idx]!=-1) return dp[idx];
int ans=Integer.MIN_VALUE;
for(int i=1; (i<=k && (i+idx)<nums.length); i++){
ans=Math.max(ans,helper(nums,k,idx+i,dp));
}
return dp[idx]=ans+nums[idx];
}
}
```