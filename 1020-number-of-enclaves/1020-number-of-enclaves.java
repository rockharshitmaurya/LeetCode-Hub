class Solution {
    public int numEnclaves(int[][] grid) {
        return solve(grid);
    }
      public int solve(int[][] board) {
        int n=board.length,m=board[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0; i<n; i++){
            if(board[i][0]==1) dfs(board,vis,i,0);
            if(board[i][m-1]==1) dfs(board,vis,i,m-1);
        }
        for(int i=0; i<m; i++){
            if(board[0][i]==1) dfs(board,vis,0,i);
            if(board[n-1][i]==1) dfs(board,vis,n-1,i);
        }
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==1 && vis[i][j]==false){
                    ans++;
                }
            }
        }
        return ans;
    }
    void dfs(int board[][],boolean vis[][],int i,int j){
        if(i<0 || j<0 || i==board.length || j==board[0].length || vis[i][j] || board[i][j]==0) return;
        vis[i][j]=true;
        dfs(board,vis,i+1,j);
        dfs(board,vis,i-1,j);
        dfs(board,vis,i,j+1);
        dfs(board,vis,i,j-1);
    }
}