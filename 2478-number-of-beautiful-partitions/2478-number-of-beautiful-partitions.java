class Solution {
    int mod = (int) 1e9 + 7;

    // int res = 0;

    boolean isPrime(char ch) {
        return ch == '2' || ch == '3' || ch == '5' || ch == '7';
    }

    int dp[][];

    public int beautifulPartitions(String s, int k, int minLength) {
        if (!isPrime(s.charAt(0)) || isPrime(s.charAt(s.length() - 1))) return 0;
        dp = new int[s.length() + 1][k + 1];
        for (int arr[] : dp) Arrays.fill(arr, -1);
        return helper(s, minLength, k - 1, minLength);
    }

    int helper(String s, int idx, int k, int len) {
        if (idx > s.length() || k < 0) return 0;

        if (idx == s.length()) {
            return k == 0 ? 1 : 0;
        }

        if (dp[idx][k] != -1) return dp[idx][k];

        int ans = 0;

        if (isPrime(s.charAt(idx)) && isPrime(s.charAt(idx - 1)) == false) {
            ans = (ans + helper(s, idx + len, k - 1, len)) % mod;
        }
        ans = (ans + helper(s, idx + 1, k, len)) % mod;

        return dp[idx][k] = (ans % mod);
    }
}
