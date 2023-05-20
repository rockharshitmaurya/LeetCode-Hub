class Solution {

    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dis[][] = new int[n][m];
        for (int arr[] : dis) {
            Arrays.fill(arr, (int) 1e9);
        }

        dis[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.offer(new int[] { 0, 0, 0 });
        int dirs[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!pq.isEmpty()) {
            int i = pq.peek()[0];
            int j = pq.peek()[1];
            int wt = pq.poll()[2];

            if (i == n - 1 && j == m - 1) return wt;

            for (int dir[] : dirs) {
                int newx = i + dir[0];
                int newy = j + dir[1];

                if (newx < 0 || newy < 0 || newx == n || newy == m) continue;
                
                if(dis[i][j]+grid[newx][newy]<dis[newx][newy]){
                    dis[newx][newy]=dis[i][j]+grid[newx][newy];
                    pq.offer(new int[]{newx,newy,dis[newx][newy]});
                }
            }
        }
        return -1;
    }
}
