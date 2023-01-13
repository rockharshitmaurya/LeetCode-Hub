class Solution {
    int max = 0;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }

        dfs(adj,0,s);
        return max;
    }

    int dfs(ArrayList<ArrayList<Integer>> adj, int root, String label) {
        int max1 = 0, max2 = 0;
        for (int child : adj.get(root)) {
            int ans = dfs(adj, child, label);
            if (label.charAt(child) != label.charAt(root)) {
                if (ans > max1) {
                    max2 = max1;
                    max1 = ans;
                } else if (ans > max2) {
                    max2 = ans;
                }
            }
        }
        
        max=Math.max(max,max1+max2+1);
        
        return max1+1;
    }
}
