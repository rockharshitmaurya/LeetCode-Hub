class Solution {
    Integer dp[][][]=new Integer[101][101][201];
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        
        return helper(s1,s2,s3,0,0,0);
    }
    
    boolean helper(String str1,String str2,String str3,int idx1,int idx2,int idx3){
        if(idx3==str3.length()) return true;
        
        // System.out.println(idx3);
        
        if(dp[idx1][idx2][idx3]!=null) return dp[idx1][idx2][idx3]==1;
        if(idx1<str1.length()){
            if(str1.charAt(idx1)==str3.charAt(idx3)) {
                if(helper(str1,str2,str3,idx1+1,idx2,idx3+1)) return true;
            }
        }
        
        if(idx2<str2.length()){
            if(str2.charAt(idx2)==str3.charAt(idx3)) {
                if(helper(str1,str2,str3,idx1,idx2+1,idx3+1)) return true;
            }
        }
        dp[idx1][idx2][idx3]=0;
        return false;
    }
}