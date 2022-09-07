class Solution {
    int parent[];
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent=new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        } 
        
        for(int arr[]:edges){
            union(arr[0],arr[1]);
        }
        
        return find(source)==find(destination);
    }
    
    
    void union(int u,int v){
        int a=find(u);
        int b=find(v);
        parent[a]=b;
    }
    
    int find(int root){
        if(root==parent[root]) return root;
        return parent[root]=find(parent[root]);
    }
}