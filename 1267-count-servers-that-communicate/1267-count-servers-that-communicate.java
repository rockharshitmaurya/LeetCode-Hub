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
    public int countServers(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        parent=new int[n+m];
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
        }
        int size[]=new int[n+m];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    union(i,j+m);
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    int x=find(i);
                    size[x]++;
                }
            }
        }
        int ans=0;
        for(int i=0; i<size.length; i++){
            if(size[i]>1) ans+=size[i];
        }
       return ans;
    }
}