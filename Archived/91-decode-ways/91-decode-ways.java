class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        dp[n]=1;
        for(int idx=n-1; idx>=0; idx--){
            // for(int idx=i; idx<n; idx++){
                if(s.charAt(idx)=='0') continue;
                int way_1=dp[idx+1];
                int way_2=0;
                if(idx<s.length()-1 && Integer.parseInt(s.substring(idx,idx+2))<=26){
                    way_2=dp[idx+2];
                }
                dp[idx]=way_1+way_2; 
            // }
        }
        return dp[0];
    }
    int helper(String str,int idx){
        if(idx==str.length()) return 1;
        
        if(str.charAt(idx)=='0') return 0;
        
        
        
        int way_1=helper(str,idx+1);
        int way_2=0;
        
        if(idx<str.length()-1 && Integer.parseInt(str.substring(idx,idx+2))<=26){
            way_2=helper(str,idx+2);
        }
        return way_1+way_2;
    }
    
}