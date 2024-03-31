class Solution {
    int mod=(int)1e9+7;
    int dp[][];
    public int countVowelPermutation(int n) {
        char ch[]={'a','e','i','o','u'};
        dp=new int[n+1][150];
        for(int arr[]:dp) Arrays.fill(arr,-1);
      return helper(ch,n,0,'#');  
    }
    int helper(char ch[],int n,int len,char last){
        if(len==n){
            return 1;
        } 
        int ans=0;
        if(dp[len][last]!=-1) return dp[len][last];
        for(int i=0; i<ch.length; i++){
    
           if(last=='#'){
               
               ans=(ans+helper(ch,n,len+1,ch[i]))%mod; 
           } 
           else if(last=='a' && ch[i]=='e') {

             ans=(ans+helper(ch,n,len+1,ch[i]))%mod;  
           }
           else if(last=='e' && (ch[i]=='a' || ch[i]=='i')){

               ans=(ans+helper(ch,n,len+1,ch[i]))%mod;
           } 
           else if(last=='i' &&(ch[i]=='a' || ch[i]=='e' || ch[i]=='o'  || ch[i]=='u')) {

               ans=(ans+helper(ch,n,len+1,ch[i]))%mod;
           }
           else if(last=='o' && (ch[i]=='i' || ch[i]=='u')){

               ans=(ans+helper(ch,n,len+1,ch[i]))%mod;
           } 
           else if(last=='u' && ch[i]=='a'){

               ans=(ans+helper(ch,n,len+1,ch[i]))%mod;
           } 
        }

        return dp[len][last]=ans;
    }
}