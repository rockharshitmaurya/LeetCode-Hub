class Solution {
    boolean vis[][];
    Queue<int[]> q;

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        // if(grid.length==n) return 0;
        vis = new boolean[n][n];
        int dirs[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        q = new LinkedList<>();
        outer:for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    break outer;
                }
            }
        }

        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.peek()[1];
            int dis = q.poll()[2];
            
            for (int arr[] : dirs) {
                int x = i + arr[0];
                int y = j + arr[1];
                if (x < 0 || x == n || y < 0 || y == n || vis[x][y]) continue;
                if(grid[x][y]==1) return dis;
                q.offer(new int[] { x, y, dis + 1 });
                vis[x][y] = true;
            }
        }

        return 0;
    }

    void dfs(int i, int j, int grid[][]) {
        if (i < 0 || i == grid.length || j < 0 || j == grid.length || grid[i][j] == 0 || vis[i][j]) return;

        vis[i][j] = true;
        q.offer(new int[] { i, j, 0 });

        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);
    }
}
// [[0,1],
//  [1,0]]
