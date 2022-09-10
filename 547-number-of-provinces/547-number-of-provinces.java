class Solution {
    int parent[],count;
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    void union(int u,int v){
        int a=find(u);
        int b=find(v);
        if(a==b) return;
        parent[a]=b;
        count--;
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        count=n;
        parent=new int[n];
        
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<isConnected[i].length; j++){
                if(isConnected[i][j]==0) continue;
                
                union(i,j);
            }
        }
        
        return count;
        
    }
}