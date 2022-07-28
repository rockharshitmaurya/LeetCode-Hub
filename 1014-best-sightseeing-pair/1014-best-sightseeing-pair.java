class Solution {
    int dp[][];
    public int maxScoreSightseeingPair(int[] values) {
        dp=new int[values.length][2];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        return helper(values,1,1,0);
    }
        int helper(int arr[],int cap,int buy,int idx){
            if(idx==arr.length || cap==0) {
                if(cap==0) return 0;
                else return Integer.MIN_VALUE;
            }

            int profit=0;
            if(dp[idx][buy]!=-1) return dp[idx][buy];
            if(buy==1){
                profit=Math.max(arr[idx]+idx+helper(arr,cap,0,idx+1),0+helper(arr,cap,1,idx+1));   
            }else{
                profit=Math.max(arr[idx]-idx+helper(arr,cap-1,1,idx+1),0+helper(arr,cap,0,idx+1));
            }
            return dp[idx][buy]=profit;
    }
    
//     int helper(int values[],int k,int idx,boolean first){
//         if(idx==values.length) return 0;
        
//         if(k==0) return 0;
        
        
//         int profit=0;
        
//         if(first){
//             profit=Math.max(idx+values[idx]+helper(values,k,idx+1,false),helper(values,k,idx+1,true));
//         }else{
//             profit=Math.max(-idx+values[idx]+helper(values,k-1,idx+1,true),helper(values,k,idx+1,false)); 
//         }
//         return profit;
//     }
}