class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        return helper(coins,amount,coins.length-1,"");
    }
    int helper(int coins[],int amount,int idx,String ans){
        if(idx==0){
            if(amount%coins[idx]==0) return 1; 
            return 0;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int take=0;
        if(coins[idx]<=amount) take=helper(coins,amount-coins[idx],idx,ans+" "+coins[idx]);
        int notTake=helper(coins,amount,idx-1,ans);
        return dp[idx][amount]=(take+notTake);
    }
}