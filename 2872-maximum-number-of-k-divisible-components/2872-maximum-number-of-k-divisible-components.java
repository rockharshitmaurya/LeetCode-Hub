class Solution {
    int ans = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int arr[] : edges) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        System.out.println(adj);
        helper(adj, 0, -1, values, k);
        return ans;
    }

    int helper(ArrayList<ArrayList<Integer>> adj, int root, int parent, int values[], int k) {
        int sum = values[root];

        for (int child : adj.get(root)) {
            if (child == parent) continue;

            sum += helper(adj, child, root, values, k);
        }

        if (sum % k == 0) {
            ans++;
            return 0;
        }

        return sum;
    }
}
