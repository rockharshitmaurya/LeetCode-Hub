class Solution {
    int n,m;
    int parent[];
    boolean res;
    int gridCopy[][];
    void union(int x,int y){
        int a=find(x);
        int b=find(y);
        parent[a]=b;
    }
    
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
      // this.grid1=grid1;
        gridCopy=grid1;
        n=grid1.length;m=grid1[0].length; 
      parent=new int[(int)1e6];
      for(int i=0; i<parent.length; i++){
          parent[i]=i;
      }
      
      for(int i=0; i<n; i++){
          for(int j=0; j<m; j++){
              if(grid1[i][j]==1) helperGrid1(grid1,i,j,(i*n)+j);
          }
      }
     int ans=0;
       
     for(int i=0; i<n; i++){
          for(int j=0; j<m; j++){
              if(grid2[i][j]==1) {
                  res=true;
                  helperGrid2(grid2,i,j,(i*n)+j);
                  if(res){
                      // System.out.println(i+" "+j);
                      ans++;
                  }
              }
          }
      }
      return ans;
    }
    
    void helperGrid1(int[][] grid1,int i,int j,int prev){
        if(i>=0 && i<n && j>=0 && j<m && grid1[i][j]==1){
            union(prev,(i*n)+j);
            grid1[i][j]=2;
            helperGrid1(grid1,i+1,j,(i*n)+j);
            helperGrid1(grid1,i-1,j,(i*n)+j);
            helperGrid1(grid1,i,j+1,(i*n)+j);
            helperGrid1(grid1,i,j-1,(i*n)+j);
            // grid1[i][j]=1;
        }
    }
    void helperGrid2(int[][] grid2,int i,int j,int prev){
        if(i>=0 && i<n && j>=0 && j<m && grid2[i][j]==1){
            res=res & (find(prev)==find((i*n)+j));
            res=res & (gridCopy[i][j]==2);
            grid2[i][j]=0;
            helperGrid2(grid2,i+1,j,(i*n)+j);
            helperGrid2(grid2,i-1,j,(i*n)+j);
            helperGrid2(grid2,i,j+1,(i*n)+j);
            helperGrid2(grid2,i,j-1,(i*n)+j);
        }
    }
}