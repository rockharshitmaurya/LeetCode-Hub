class Solution {
    public int maxSatisfaction(int[] sat) {
        int n=sat.length;
        int dp[][]=new int[n+1][n+2];
        Arrays.sort(sat);
        
        for(int idx=n-1; idx>=0; idx--){
            for(int time=1; time<=n; time++){
                        int pick=sat[idx]*time+dp[idx+1][time+1];
                        int notpick=dp[idx+1][time];
                        dp[idx][time]=Math.max(pick,notpick);
            }
        }
        return dp[0][1];
    }
    
    int helper(int sat[],int idx,int time){
        if(idx==sat.length) return 0;
        
        
        int pick=sat[idx]*time+helper(sat,idx+1,time+1);
        int notpick=helper(sat,idx+1,time);
        
        
        return Math.max(pick,notpick);
    }
}