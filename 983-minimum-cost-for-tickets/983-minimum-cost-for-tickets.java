class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int dp[][]=new int[n][days[n-1]+40];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        return helper(days,costs,0,0,dp);
    }
    int helper(int days[],int costs[],int idx,int limit,int dp[][]){
        if(idx>=days.length) return 0;
        if(dp[idx][limit]!=-1) return dp[idx][limit];
        
        if(days[idx]<limit) return helper(days,costs,idx+1,limit,dp); 
        
        int one_day=costs[0]+helper(days,costs,idx+1,days[idx],dp);
        int seven_day=costs[1]+helper(days,costs,idx+1,days[idx]+7,dp);
        int thirty_day=costs[2]+helper(days,costs,idx+1,days[idx]+30,dp);
        
        return dp[idx][limit]=Math.min(one_day,Math.min(seven_day,thirty_day));
    }
}
// 0 1 2 3 4 5 6 7 8 9 10 11