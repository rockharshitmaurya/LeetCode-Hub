class Solution {
    int inf = (int) 1e8;
    int dp[][];
    public int minDifficulty(int[] job, int d1) {
        
        int n = job.length;
        dp=new int[n+1][d1+1];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        if (n < d1) return -1;
        
        
        return helper(job,d1,0);
    }

    int helper(int job[], int d, int idx) {
        if (idx == job.length) {
            if (d == 0) return 0;
            else return inf;
        }

        if (d == 0) return inf;
        if(dp[idx][d]!=-1) return dp[idx][d];
        int ans = inf, max = 0;
        for (int i = idx; i < job.length; i++) {
            max = Math.max(max, job[i]);
            ans = Math.min(ans, max + helper(job, d - 1, i + 1));
        }

        return dp[idx][d]=ans;
    }
}
