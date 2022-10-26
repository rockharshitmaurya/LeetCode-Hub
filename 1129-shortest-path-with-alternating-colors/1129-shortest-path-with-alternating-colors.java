class Solution {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int INF = (int) 1e9;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int arr[] : redEdges) {
            adj.get(arr[0]).add(new int[] { arr[1], 0 });
        }
        for (int arr[] : blueEdges) {
            adj.get(arr[0]).add(new int[] { arr[1], 1 });
        }

        int dis[][] = new int[2][n];
        Arrays.fill(dis[0], INF);
        Arrays.fill(dis[1], INF);

        //0 --> red
        //1 --> blue

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 2, 0 });
        dis[0][0] = 0;
        dis[1][0] = 0;
        while (!q.isEmpty()) {
            int node = q.peek()[0];
            int root_col = q.peek()[1];
            int d = q.poll()[2];

            for (int arr[] : adj.get(node)) {
                int child = arr[0], child_col = arr[1];
                if (root_col != child_col && 1 + d < dis[child_col][child]) {
                    dis[child_col][child] = 1 + d;
                    q.offer(new int[] { child, child_col, 1 + d });
                }
            }
        }
        for (int i = 0; i < n; i++) dis[0][i] = Math.min(dis[0][i], dis[1][i]);
        for (int i = 0; i < n; i++) if (dis[0][i] == INF) dis[0][i] = -1;
        // System.out.println(Arrays.deepToString(dis));
        return dis[0];
    }
}
