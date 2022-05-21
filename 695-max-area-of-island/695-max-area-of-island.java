class Solution {
    public int maxAreaOfIsland(int[][] grid) {
       int n=grid.length,m=grid[0].length;
       boolean visited[][]=new boolean[n][m];
       int ans=0;
       for(int i=0; i<n; i++){
           for(int j=0; j<m; j++){
               if(grid[i][j]==1 && visited[i][j]==false){
                   int count=dfs(grid,i,j,n,m,visited);
                   ans=Math.max(ans,count);
               }
           }
       }
        return ans;
    }
    int dfs(int[][] grid,int i,int j,int n,int m,boolean visited[][]){
        int ans=0;
        if(!(i<0 || i>=n || j<0 || j>=m || visited[i][j]==true || grid[i][j]==0)){
           visited[i][j]=true;
           ans++;
           ans+=dfs(grid,i,j+1,n,m,visited); 
           ans+=dfs(grid,i,j-1,n,m,visited); 
           ans+=dfs(grid,i+1,j,n,m,visited); 
           ans+=dfs(grid,i-1,j,n,m,visited); 
        }
        return ans;
    }
}