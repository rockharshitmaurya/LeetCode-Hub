class Solution {
    int dirs[][] = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int n, m;

    boolean ok(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public int minCost(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int cost[][] = new int[n][m];
        int max = (int) 1e9;
        for (int arr[] : cost) Arrays.fill(arr, max);
        q.offer(new int[] { 0, 0 });
        cost[0][0] = 0;
        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.poll()[1];

            // System.out.println(i + " " + j + " " + val);
            if (i == n - 1 && j == m - 1) {
                continue;
            }

            for (int move = 1; move < dirs.length; move++) {
                int newx = i + dirs[move][0];
                int newy = j + dirs[move][1];

                if (!ok(newx, newy)) continue;

                // if (move == grid[i][j] && cost[i][j]) {
                //     cost[newx][newy] = val;
                //     q.offer(new int[] { newx, newy, val });
                // } else

                int cur_cost = (move == grid[i][j]) ? 0 : 1;

                if (cost[i][j] + cur_cost < cost[newx][newy]) {
                    cost[newx][newy] = cost[i][j] + cur_cost ;
                    q.offer(new int[] { newx, newy });
                }
            }
        }

        return cost[n-1][m-1];
    }
}
