class Solution {
    int dp[];

    public int numSquares(int n) {
        dp = new int[n + 1];
        // for (int arr[] : dp) Arrays.fill(arr, -1);
        Arrays.fill(dp, -1);
        return helper(1, n);
    }

    int helper(int no, int n) {
        if (n == 0) {
            return 0;
        }
        
        if ((no * no) > n) return (int) 1e5;
        
        // if(n%(no*no)==0) return n/(no*no);
        
        if (dp[n] != -1) return dp[n];

        int take = 1 + helper(no, n - (no * no));
        int nottake = helper(no + 1, n);

        return dp[n] = Math.min(take, nottake);
    }
}
