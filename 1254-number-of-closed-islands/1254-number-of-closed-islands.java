class Solution {
    public int closedIsland(int[][] grid) {
       int n=grid.length,m=grid[0].length;
        for(int i=0; i<m; i++){
            if(grid[0][i]==0) makeOne(0,i,grid);
            if(grid[n-1][i]==0) makeOne(n-1,i,grid);
        }
        for(int i=0; i<n; i++){
            if(grid[i][0]==0) makeOne(i,0,grid);
            if(grid[i][m-1]==0) makeOne(i,m-1,grid);
        }
        
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0){
                    ans++; makeOne(i,j,grid);
                }
            }
        }
       return ans; 
    }
    void makeOne(int i,int j,int[][] grid){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]==1) return;
        grid[i][j]=1;
        makeOne(i+1,j,grid);
        makeOne(i,j+1,grid);
        makeOne(i-1,j,grid);
        makeOne(i,j-1,grid);
    }
}