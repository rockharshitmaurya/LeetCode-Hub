class Solution {
    public int coinChange(int[] coins, int amount) {
      int max=amount+1;
        int dp[]=new int[max];
        Arrays.fill(dp,max);
        dp[0]=0;
        // for(int i=1; i<=amount; i++){
        //     for(int j=0; j<coins.length; j++){
        //         if(coins[j]<=i){
        //             dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
        //         }
        //     }    
        // }
        for(int coin:coins){
            for(int i=coin; i<=amount; i++){
               // if(coin<=i){
                  dp[i]=Math.min(dp[i],dp[i-coin]+1);  
               // }
            }
        }
        return dp[amount]>amount?-1:dp[amount]; 
    }
}