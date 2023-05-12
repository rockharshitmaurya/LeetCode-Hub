class Solution {
public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            int point = questions[i][0], brain = questions[i][1];
            dp[i] = point;
            if (i < n - brain) {
                dp[i] += dp[i + brain + 1];
            }
            dp[i] = Math.max(dp[i + 1], dp[i]);
        }
        return dp[0];        
    }
}