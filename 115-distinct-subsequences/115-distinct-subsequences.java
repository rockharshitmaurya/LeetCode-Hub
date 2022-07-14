class Solution {
    int dp[][];
    public int numDistinct(String s, String t) {
        dp=new int[s.length()][t.length()];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        return helper(s,t,s.length()-1,t.length()-1);
    }
    int helper(String str,String target,int i,int j){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(str.charAt(i)==target.charAt(j)) return dp[i][j]=helper(str,target,i-1,j-1)+helper(str,target,i-1,j);

        return dp[i][j]=helper(str,target,i-1,j);
    }
}