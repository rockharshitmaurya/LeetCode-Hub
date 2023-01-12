class Solution {
    int ans[];

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int arr[] : edges) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        int frq[] = new int[26];
        ans = new int[n];

        helper(adj, 0, -1, frq, labels);
        // System.out.println(Arrays.toString(frq));
        return ans;
    }

    void helper(ArrayList<ArrayList<Integer>> adj, int root, int parent, int freq[], String label) {
        int prev = freq[label.charAt(root) - 'a'];
        for (int child : adj.get(root)) {
            if (child == parent) continue;
            helper(adj, child, root, freq, label);
        }
        // freq[label.charAt(root) - 'a']++;
        ans[root] = ++freq[label.charAt(root) - 'a']-prev;
    }
}
