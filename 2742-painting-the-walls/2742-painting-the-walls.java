class Solution {
    int inf = (int) 1e9 + 7;
    int[][] dp;
    int offset;

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        offset = n;
        dp = new int[n + 1][2 * n + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        return helper(cost, time, 0, 0);
    }

    int helper(int[] cost, int[] time, int idx, int cur_time) {
        if (idx == time.length) {
            return (cur_time >= 0) ? 0 : inf;
        }
        if (cur_time >= time.length) return 0;

        if (dp[idx][cur_time + offset] != -1) {
            return dp[idx][cur_time + offset];
        }

        int pick = helper(cost, time, idx + 1, cur_time - 1);
        int notpick = cost[idx] + helper(cost, time, idx + 1, cur_time + time[idx]);

        dp[idx][cur_time + offset] = Math.min(pick, notpick);
        return Math.min(pick, notpick);
    }
}
