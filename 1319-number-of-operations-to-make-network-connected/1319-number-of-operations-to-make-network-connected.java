class Solution {
    int parent[];
    void union(int u,int v){
        int a=find(u);
        int b=find(v);
        parent[a]=b;
    }
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    public int makeConnected(int n, int[][] connections) {
        parent=new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        
        int avl=0;
        
        for(int arr[]:connections){
            if(find(arr[0])!=find(arr[1])) union(arr[0],arr[1]);
            else avl++;
        }
        int comp=0;
        for(int i=0; i<n; i++){
            if(parent[i]==i) comp++;
        }
        
        
        

        return (avl>=comp-1)?(comp-1):-1;
    }
}