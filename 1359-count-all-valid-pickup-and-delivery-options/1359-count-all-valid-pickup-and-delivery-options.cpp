class Solution {
public:
    int mod=1e9+7;
    long long int dp[501][501];
    long long int func(int pick,int del)
    {
        if(del<0||pick<0)return 0;//base case as it can't be negative
        
        if(del<pick)return 0; // condition to insure we are first picking then delivering 
        
        if(pick==0&&del==0)return 1;//everything finishes return 1
        
        if(dp[pick][del]!=-1)return dp[pick][del]; //memoization 
        
        long long int ans=0; // initializing the answer
        
        ans+=pick*func(pick-1,del); // if there are pick number of orders we have [pick]C1 = pick number of choices for selecting  and we have picked one so we do pick-1
        ans%=mod;
        
        ans+=(del-pick)*func(pick,del-1);// delivering : the number of items we have picked but not delivered is (del-pick) so we can select one item from these to deliver [del-pick]C1  =del-pick and we have delivered so del-1
        ans%=mod;
        
        return dp[pick][del]=ans;
        
    }
    int countOrders(int n) {
        memset(dp,-1,sizeof(dp));
        return func(n,n);// passing pick and del
    }
};