**Coin Change--( fewest number of coins )**
​
[https://leetcode.com/problems/coin-change/](http://)
​
​
```
public int coinChange(int[] coins, int amount) {
int max=amount+1;
int dp[]=new int[max];
Arrays.fill(dp,max);
dp[0]=0;
for(int coin:coins){
for(int i=coin; i<=amount; i++){
dp[i]=Math.min(dp[i],dp[i-coin]+1);
}
}
return dp[amount]>amount?-1:dp[amount];
}
```
​