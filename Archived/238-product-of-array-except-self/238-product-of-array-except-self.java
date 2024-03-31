class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        
        int prev=1;
        for(int i=0; i<n; i++){
            prefix[i]=nums[i]*prev;
            prev=prefix[i];
        }
        prev=1;
        for(int i=n-1; i>=0; i--){
            suffix[i]=nums[i]*prev;
            prev=suffix[i];
        }
        
        int ans[]=new int[n];
        
        for(int i=0; i<n; i++){
            int preVal=i==0?1:prefix[i-1];
            int suffVal=i==n-1?1:suffix[i+1];
            ans[i]=preVal*suffVal;
        }
        
        return ans;
    }
}