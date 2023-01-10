class Solution {
    int mod = (int) 1e9 + 7;
    int dp[][];

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        dp = new int[n + 1][n+1];
        for(int arr[]:dp)
            Arrays.fill(arr,-1);
        return 1 + helper(n, delay, forget, 1);
    }

    int helper(int n, int delay, int forget, int day) {
        if (n < 1) return 0;
        if (day > forget) return -1;
        if (dp[n][day] != -1) return dp[n][day];
        int add1 = 0;
        if (day > delay) {
            add1 = 1 + helper(n, delay, forget, 1);
        }
        int add2 = helper(n - 1, delay, forget, day + 1);

        return dp[n][day] = (add1 + add2)%mod;
    }
}
