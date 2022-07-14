class Solution {

    public int numDistinct(String s, String t) {
        int n=s.length(),m=t.length();
            int dp[][]=new int[n+1][m+1];
        for(int i=0; i<=n; i++) dp[i][0]=1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1)==t.charAt(j-1)) 
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
            }
        }
          return dp[n][m];  
        // return helper(s,t,s.length()-1,t.length()-1);
    }
//     int helper(String str,String target,int i,int j){
//         if(j<0) return 1;
//         if(i<0) return 0;
//         if(dp[i][j]!=-1) return dp[i][j];
//         if(str.charAt(i)==target.charAt(j)) 
//             return dp[i][j]=helper(str,target,i-1,j-1)+helper(str,target,i-1,j);

//         return dp[i][j]=helper(str,target,i-1,j);
//     }
}