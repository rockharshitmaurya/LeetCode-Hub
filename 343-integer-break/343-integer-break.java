class Solution {
    int ans=0;
    public int integerBreak(int n) {
        if(n==2) return 1;
        else if(n==3) return 2;
        int arr[]=new int[n];
        for(int i=0; i<n; i++) arr[i]=i+1;
        helper(n-1,arr,n,1);
        return ans;
    }
    void helper(int idx,int arr[],int n,int pro){
        if(idx==-1){
            if(n==0){
                ans=Math.max(ans,pro);
            }
            return;
        }
        
        if(arr[idx]<=n) helper(idx,arr,n-arr[idx],pro*arr[idx]);
        helper(idx-1,arr,n,pro);
    }
}