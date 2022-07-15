class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        return helper(prices,0,true);
    }
    int helper(int arr[],int idx,boolean buy){
        if(idx==arr.length) return 0;
        int j=buy==true?1:0;
        if(dp[idx][j]!=-1) return dp[idx][j];
        int profit=0;
        if(buy){
            profit=Math.max(helper(arr,idx+1,false)-arr[idx],0+helper(arr,idx+1,true));
        }else{
            profit=Math.max(arr[idx]+helper(arr,idx+1,true),0+helper(arr,idx+1,false));
        }
        return dp[idx][j]=profit;
    }
}