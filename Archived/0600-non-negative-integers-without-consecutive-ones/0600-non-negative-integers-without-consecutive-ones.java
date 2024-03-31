class Solution {

    int dp[][][];

    public int findIntegers(int n) {
        dp = new int[32][2][2];
        for (int arr[][] : dp) {
            for (int arr2[] : arr) {
                Arrays.fill(arr2, -1);
            }
        }
        return helper(Integer.toBinaryString(n), 0, 1, 0);
    }

    int helper(String num, int idx, int limit, int last) {
        if (num.length() == idx) {
            // System.out.println(str);
            return 1;
        }

        int end = (limit == 1) ? (num.charAt(idx) - '0') : 1;
        int ans = 0;
        if(dp[idx][limit][last]!=-1) return dp[idx][limit][last];
        for (int dig = 0; dig <= end; dig++) {
            int new_limit = (limit == 1 && dig == end) ? 1 : 0;
            if (last == 1 && dig == 1) continue;
            ans = ans + helper(num, idx + 1, new_limit, dig);
        }

        return dp[idx][limit][last]=ans;
    }
    //     int helper(int n, int idx, int mask, int canPlace) {
    //         if (mask > n) return 0;
    //         if (idx == 32) return 1;

    //         int mod=100000;
    //         // int last=canPlace==1?1:0;
    //         if (dp[idx][canPlace][mask%mod] != -1) return dp[idx][canPlace][mask%mod];
    //         int ans = 0;
    //         ans += helper(n, idx + 1, mask, 0);
    //         if (canPlace != 1) ans += helper(n, idx + 1, (mask | (1 << idx)), 1);
    //         return dp[idx][canPlace][mask%mod] = ans;
    //     }
}
