class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int ans=0;
        
        for(int num:prices){
            ans=Math.max(ans,num-buy);
            buy=Math.min(buy,num);
        }
        
        
        return ans;
    }
}