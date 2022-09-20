class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        int dp_cur[]=new int[m+1],dp_prev[]=new int[m+1];
        
        int ans=0;
        for(int i=1; i<=n; i++){
            dp_cur=new int[m+1];
            for(int j=1; j<=m; j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp_cur[j]=1+dp_prev[j-1]; // if the prev char matches then the current res will be length of prev match and +1 for the current match 
                    ans=Math.max(ans,dp_cur[j]);
                }else{
                    dp_cur[j]=0; // if not match then  the cur ans will be zero
                }
            }
            dp_prev=dp_cur;
        }
        
        return ans;
    }
}