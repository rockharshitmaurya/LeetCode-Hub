class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
       int sum=0;
       for(int i=0; i<nums.length; i++){
           if((nums[i]&1)==0) sum+=nums[i];
       }
       int ans[]=new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int val=queries[i][0];
            int idx=queries[i][1];  
            int prev=nums[idx];
            
            if((prev&1)==0)
                sum-=prev;
            nums[idx]+=val;
            if((nums[idx]&1)==0) sum+=nums[idx];
            
            ans[i]=sum;
        }
        return ans;
    }
}