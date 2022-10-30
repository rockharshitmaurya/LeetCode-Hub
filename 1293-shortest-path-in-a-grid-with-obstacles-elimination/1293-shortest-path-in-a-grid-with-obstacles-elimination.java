class Solution {

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int vis[][] = new int[n][m];
        for (int arr[] : vis) {
            Arrays.fill(arr, (int) 1e9);
        }
        vis[n - 1][m - 1] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { n - 1, m - 1, 0 });

        int dirs[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int l = 0; l < size; l++) {
                int i = q.peek()[0];
                int j = q.peek()[1];
                int ob = q.poll()[2];
                if(i==0 && j==0) return ans;
                for (int d[] : dirs) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x < 0 || y < 0 || x == n || y == m) continue;
                    
                    int new_ob = ob+grid[x][y];
                    
                    if(new_ob>=vis[x][y] || new_ob>k) continue;
                    
                    vis[x][y]=new_ob;
                    q.offer(new int[]{x,y,new_ob});
                }
            }
            ans++;
        }

        return -1;
    }
}
