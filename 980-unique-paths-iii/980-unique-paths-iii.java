class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    return helper(grid,vis,i,j);
                }
            }
        }
        return 0;
    }
    
    int helper(int grid[][],boolean vis[][],int i, int j){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]==-1) return 0;
        
        if(grid[i][j]==2){
            if(check(grid)) return 1;
            else return 0;
        }
        
        int val=grid[i][j];
        grid[i][j]=-1;
        
        
        int one=helper(grid,vis,i+1,j);
        int two=helper(grid,vis,i-1,j);
        int three=helper(grid,vis,i,j+1);
        int four=helper(grid,vis,i,j-1);
        
        
        
        grid[i][j]=val;
        
        return one+two+three+four;
        
    }
    
    boolean check(int grid[][]){
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==0) return false;
            }
        }
        
        return true;
    }
}