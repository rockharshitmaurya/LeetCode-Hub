class Solution {
    int inf = (int) 1e9 + 7;
    int dp[][][];

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        dp = new int[n + 1][n + 1][2];
        // map = new int[n + 1];
        for (int arr[][] : dp) for (int arr2[] : arr) Arrays.fill(arr2, -1);
        return helper(cost, time, 0, 0);
    }

    int helper(int cost[], int time[], int idx, int cur_time) {
        if (idx == time.length) {
            if (cur_time >= 0) return 0; else return inf;
        }
        if (cur_time >= time.length) return 0;
        int pick = inf, notpick = inf;
        int flip = (cur_time < 0) ? 0 : 1;
        if (dp[idx][cur_time < 0 ? cur_time * -1 : cur_time][flip] != -1) return dp[idx][cur_time < 0 ? cur_time * -1 : cur_time][flip];

        pick = helper(cost, time, idx + 1, cur_time - 1);
        notpick = cost[idx] + helper(cost, time, idx + 1, cur_time + time[idx]);

        dp[idx][cur_time < 0 ? cur_time * -1 : cur_time][flip] = Math.min(pick, notpick);
        return Math.min(pick, notpick);
    }
}
