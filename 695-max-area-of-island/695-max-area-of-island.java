class Solution {
    int count=0;
    public int maxAreaOfIsland(int[][] grid) {
       int n=grid.length,m=grid[0].length;
       boolean visited[][]=new boolean[n][m];
       int ans=0;
       for(int i=0; i<n; i++){
           for(int j=0; j<m; j++){
               if(grid[i][j]==1 && visited[i][j]==false){
                   dfs(grid,i,j,n,m,visited);
                   ans=Math.max(ans,count);
                   count=0;
               }
           }
       }
        return ans;
    }
    void dfs(int[][] grid,int i,int j,int n,int m,boolean visited[][]){
        if(!(i<0 || i>=n || j<0 || j>=m || visited[i][j]==true || grid[i][j]==0)){
           visited[i][j]=true;
           count++;
           dfs(grid,i,j+1,n,m,visited); 
           dfs(grid,i,j-1,n,m,visited); 
           dfs(grid,i+1,j,n,m,visited); 
           dfs(grid,i-1,j,n,m,visited); 
        }
    }
}