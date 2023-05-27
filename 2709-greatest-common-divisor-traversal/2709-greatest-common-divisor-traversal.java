class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        return canTraverse(nums);
    }
    public boolean canTraverse(int[] nums) {
        int n = nums.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        List<Integer>[] factors = new ArrayList[100001];
        for (int i = 0; i <= 100000; i++) {
            factors[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    factors[j].add(i);
                    while (num % j == 0) num /= j;
                }
            }
            if (num > 1) factors[num].add(i);
        }
        for (List<Integer> factor : factors) {
            for (int i = 1; i < factor.size(); i++) {
                int u = factor.get(i - 1), v = factor.get(i);
                graph[u].add(v);
                graph[v].add(u);
            }
        }
        boolean[] visited = new boolean[n];
        dfs(graph, visited, 0);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(List<Integer>[] graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}

