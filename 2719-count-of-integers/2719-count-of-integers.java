class Solution {
    int MOD = (int) 1e9 + 7;
    int dp[][][] = new int[23][401][2];

    public int count(String num1, String num2, int min_sum, int max_sum) {
        for (int arr[][] : dp) {
            for (int arr2[] : arr) {
                Arrays.fill(arr2, -1);
            }
        }
        int max = helper(num2, min_sum, max_sum, 0, 1, 0);
        for (int arr[][] : dp) {
            for (int arr2[] : arr) {
                Arrays.fill(arr2, -1);
            }
        }
        int min = helper(num1, min_sum, max_sum, 0, 1, 0);
        int ans = max - min;

        int d_sum = 0;

        for (char ch : num1.toCharArray()) {
            d_sum += (ch - '0');
        }
        if (d_sum >= min_sum && d_sum <= max_sum) {
            ans=(1+ans)%MOD;
        }

        return (ans+MOD)%MOD;
    }

    int helper(String num, int min, int max, int idx, int limit, int sum) {
        if (idx == num.length()) {
            if (sum >= min && sum <= max) return 1; else return 0;
        }

        if (dp[idx][sum][limit] != -1) return dp[idx][sum][limit];
        int ans = 0;
        // System.out.println(idx);
        int end = limit == 1 ? num.charAt(idx) - '0' : 9;

        for (int i = 0; i <= end; i++) {
            int new_limit = (limit == 1 && i == end) ? 1 : 0;
            ans = (ans + helper(num, min, max, idx + 1, new_limit, sum + i)) % MOD;
        }

        return dp[idx][sum][limit] = ans;
    }
}
