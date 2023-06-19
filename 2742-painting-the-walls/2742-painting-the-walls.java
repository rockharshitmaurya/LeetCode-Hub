class Solution {
    int inf = (int) 1e9 + 7;
    int[][][] dp;

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        dp = new int[n + 1][n + 1][2];
        for (int[][] arr : dp)
            for (int[] arr2 : arr)
                Arrays.fill(arr2, -1);
        return helper(cost, time, 0, 0);
    }

    int helper(int[] cost, int[] time, int idx, int cur_time) {
        if (idx == time.length) {
            return (cur_time >= 0) ? 0 : inf;
        }
        if (cur_time >= time.length) return 0;

        int flip = (cur_time < 0) ? 0 : 1;
        if (dp[idx][Math.abs(cur_time)][flip] != -1) {
            return dp[idx][Math.abs(cur_time)][flip];
        }

        int pick = helper(cost, time, idx + 1, cur_time - 1);
        int notpick = cost[idx] + helper(cost, time, idx + 1, cur_time + time[idx]);

        dp[idx][Math.abs(cur_time)][flip] = Math.min(pick, notpick);
        return Math.min(pick, notpick);
    }
}
