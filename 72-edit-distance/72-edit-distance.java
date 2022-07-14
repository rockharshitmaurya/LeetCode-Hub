class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        dp=new int[n+1][m+1];
        for(int arr[]:dp)   Arrays.fill(arr,-1);
        return helper(word1,word2,n,m);
    }
    int helper(String str1,String str2, int i,int j){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(str1.charAt(i-1)==str2.charAt(j-1)) return dp[i][j]=helper(str1,str2,i-1,j-1);
        int insert=1+helper(str1,str2,i,j-1);
        int delete=1+helper(str1,str2,i-1,j);
        int replace=1+helper(str1,str2,i-1,j-1);
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }
}