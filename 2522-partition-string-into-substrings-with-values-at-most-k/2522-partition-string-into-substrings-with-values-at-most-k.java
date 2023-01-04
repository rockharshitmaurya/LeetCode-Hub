class Solution {
    int inf=(int)1e6;
    int dp[];
    public int minimumPartition(String s, int k) {
        int n=s.length();
        dp=new int[n];
        // for(int arr[]:dp) 
            Arrays.fill(dp,-1);
     int ans = helper(s,k,0,0);  
    return ans>=inf?-1:ans;
    }
    
    int helper(String s,int k,int idx,int start){
        if(idx==s.length()) return 1;
        long num=Long.parseLong(s.substring(start,idx+1));
        if(num>k) return inf;
        if(dp[start]!=-1) return dp[start];
        int part=1+helper(s,k,idx+1,idx+1);
        int notyet=helper(s,k,idx+1,start);
        return dp[start]=Math.min(part,notyet);
    }
}