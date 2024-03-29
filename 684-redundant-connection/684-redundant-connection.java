class Solution {
    int parent[],rank[];
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    
    void union(int u,int v){
        int a=find(u);
        int b=find(v);
        if(rank[a]>rank[b]){
            parent[b]=a;
        }else if(rank[b]>rank[a]){
            parent[a]=b;
        }else{
            parent[a]=b;
            rank[b]++;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1]; rank=new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i]=i;
        }
        
        for(int arr[]:edges){
            if(find(arr[0])!=find(arr[1])){
                union(arr[0],arr[1]);
            }else{
                return arr;
            }
        }
        return new int[]{-1,-1};
    }
}