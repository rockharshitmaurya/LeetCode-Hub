class Solution {
    int parent[], rank[];

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int u, int v) {
        int a = find(u);
        int b = find(v);
        if (rank[a] > rank[b]) {
            parent[b] = a;
        } else if (rank[b] > rank[a]) {
            parent[a] = b;
        } else {
            parent[a] = b;
            rank[b]++;
        }
    }

    public int findCircleNum(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        for(int i=0; i<edges.length; i++){
            for(int j=0; j<edges.length; j++){
                if(edges[i][j]==1){
                    union(i,j);
                }
            }
        }
        
        int ans=0;
        
        for(int i=0; i<parent.length; i++){
            if(parent[i]==i) ans++;
        }
        return ans-1;
    }
}
