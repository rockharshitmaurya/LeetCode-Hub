class Solution {
    int parent[];

    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        parent = new int[n+1];
        for (int i = 0; i <parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i<=n; i++) adj.add(new ArrayList<>());
        
        for(int arr[]:dislikes){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        
        for(int i=0; i<=n; i++){
            if(adj.get(i).size()==0) continue;
            
            for(int j=1; j<adj.get(i).size(); j++){
                if(find(i)==find(adj.get(i).get(j))) return false;
                union(find(adj.get(i).get(0)),find(adj.get(i).get(j)));
            }
        }
        
        
        return true;
    }

    void union(int u, int v) {
        int a = find(u);
        int b = find(v);

        parent[a] = b;
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
