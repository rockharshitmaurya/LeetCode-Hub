class Solution {

    public int integerBreak(int n) {
        int arr[] = new int[n - 1];
        int dp[][] = new int[n][n + 1];
        for (int sub[] : dp) Arrays.fill(sub, -1);
        for (int i = 0; i < n - 1; i++) arr[i] = i + 1;
        return helper(n - 2, n, dp);
    }

    int helper(int idx, int n, int dp[][]) {
        if (idx == -1) return 0;
        if (n == 0) {
            return 1;
        }
        if (dp[idx][n] != -1) return dp[idx][n];
        int left = 1, right = 1;
        if ((idx + 1) <= n) left = (idx + 1) * helper(idx, n - (idx + 1), dp);
        right = helper(idx - 1, n, dp);
        return dp[idx][n] = Math.max(left, right);
    }
}
