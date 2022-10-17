class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        // boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // visited[i][j] = true;
                    queue.offer(new int[]{i, j,0});
                }
            }
        }
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int res = -1;
        while (!queue.isEmpty()) {
            int i=queue.peek()[0];
            int j=queue.peek()[1];
            int d=queue.poll()[2];
            for (int[] dir: dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                int dis=d+1;
                // if (x >= 0 && x <n && y >= 0 && y < n && grid[x][y]==0) {
                    // visited[x][y] = true;
                if(x<0 || x==n || y<0 || y==n || grid[x][y]!=0) continue;
                    grid[x][y] = dis;
                    res = Math.max(grid[x][y], res);
                    queue.offer(new int[]{x, y,grid[x][y]});
                // }
            }
        }
        return res;
    }
}