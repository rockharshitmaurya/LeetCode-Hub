class Graph {
    ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
    int V;

    public Graph(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        V = n;
        for (int arr[] : edges) {
            adj.get(arr[0]).add(new int[] { arr[1], arr[2] });
        }
    }

    public void addEdge(int[] arr) {
        adj.get(arr[0]).add(new int[] { arr[1], arr[2] });
    }

    public int shortestPath(int node1, int node2) {
        return dijkstra(node1, node2);
    }

    public int dijkstra(int src, int des) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { src, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int distance = curr[1];
            for (int[] neighbor : adj.get(node)) {
                int newDistance = dist[node] + neighbor[1];
                if (newDistance < dist[neighbor[0]]) {
                    dist[neighbor[0]] = newDistance;
                    pq.offer(new int[] { neighbor[0], newDistance });
                }
            }
        }
        return dist[des] == Integer.MAX_VALUE ? -1 : dist[des];
    }
}
/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
