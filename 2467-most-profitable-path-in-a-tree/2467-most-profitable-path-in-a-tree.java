class Solution {

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = amount.length + 1;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int arr[] : edges) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[] vis = new boolean[n];

        // Calculate time taken by bob at each node till it reaches node 0
        dfs(bob, 0, 0, adj, vis, map);

        vis = new boolean[n];

        Queue<int[]> q = new LinkedList<>();

        int ans = Integer.MIN_VALUE;

        q.offer(new int[] { 0, 0, 0 }); //node , sum , time

        while (!q.isEmpty()) {
            int root = q.peek()[0];
            int sum = q.peek()[1];
            int time = q.poll()[2];

            if (map.containsKey(root)) {
                int bob_time = map.get(root);
                if (bob_time == time) {
                    sum += (amount[root]/2);
                } else if (time < bob_time) {
                    sum += amount[root];
                } else {
                    sum += 0;
                }
            } else {
                sum += amount[root];
            }
            vis[root] = true;

            if (root != 0 && adj.get(root).size() == 1) {
                ans = Math.max(ans, sum);
                continue;
            }
            for (int node : adj.get(root)) {
                if (!vis[node]) {
                    q.offer(new int[] { node, sum, time + 1 });
                }
            }
        }

        return ans;
    }

    private boolean dfs(int src, int target, int time, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, HashMap<Integer, Integer> map) {
        visited[src] = true;
        map.put(src, time);
        if (src == target) {
            return true;
        }
        for (Integer adjNode : adjList.get(src)) {
            if (!visited[adjNode]) {
                if (dfs(adjNode, target, time + 1, adjList, visited, map)) {
                    return true;
                }
            }
        }

        map.remove(src);
        return false;
    }
}
