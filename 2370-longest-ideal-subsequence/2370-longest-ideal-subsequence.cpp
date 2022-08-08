class Solution {
    int dp[100005][28];
int longest(string &s , int last , int n , int k){
    if(n == 0)
        return  dp[n][last]= 0;
    if(dp[n][last] != -1)
        return dp[n][last];
    else{
        if(last == 27)
            dp[n][last] =  max(1+longest(s,(s[n-1] - 'a'),n-1,k) , longest(s,last,n-1,k));
        else if( abs(last - (s[n-1] - 'a')) > k )
            dp[n][last] = longest(s,last,n-1,k);
        else
            dp[n][last] = max(1 + longest(s,s[n-1]-'a',n-1,k) , longest(s,last,n-1,k));
    }
    
    return dp[n][last];
}
    public:
    int longestIdealString(string s, int k) {
        int n = s.size();
        memset(dp,-1,sizeof(dp));
        return longest(s,27,n,k);
    }
};