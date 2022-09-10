class Solution {
    Integer dp[][][];
    public int maxProfit(int k, int[] prices) {
        dp=new Integer[prices.length][2][k+1];
        return helper(prices,0,1,k);
    }
    
    
    int helper(int prices[],int idx,int buy,int cap){
        
        if(idx==prices.length || cap==0){
           return 0;
        }
        
        if(dp[idx][buy][cap]!=null) return dp[idx][buy][cap];
        
        int profit=0;
        
        if(buy==1){
                 profit=Math.max(-prices[idx]+helper(prices,idx+1,0,cap),0+helper(prices,idx+1,1,cap));   
        }else{
                 profit=Math.max(prices[idx]+helper(prices,idx+1,1,cap-1),helper(prices,idx+1,0,cap));
        }
        
        
        return dp[idx][buy][cap]=profit;
        
        // return profit;
    }
}