class Solution {
    class Tuple{
        int row;
        int col;
        int dis;
        Tuple(int row,int col,int dis){
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] grid)
    {
        int n=grid.length,m=grid[0].length;
        int ans[][]=new int[n][m];
        boolean vis[][]=new boolean[n][m];
        
        Queue<Tuple> q=new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0){
                    q.offer(new Tuple(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int dis=q.peek().dis;
            q.poll();
            ans[row][col]=dis;
            int dirs[][]={{-1,0},{1,0},{0,-1},{0,1}};
            
            for(int arr[]:dirs){
                int nrow=row+arr[0];
                int ncol=col+arr[1];
                
                if(isValid(nrow,ncol,vis)){
                    vis[nrow][ncol]=true;
                    q.offer(new Tuple(nrow,ncol,dis+1));
                }
            }
            
        }
        
        
        return ans;
    }
    boolean isValid(int i,int j,boolean vis[][]){
        if(i>=0 && i<vis.length && j>=0 && j<vis[0].length && vis[i][j]==false) return true;
        return false;
    }
    int dfs(int grid[][],boolean vis[][],int i,int j,int dis){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j]) 
                    return Integer.MAX_VALUE;
        
        if(grid[i][j]==1) return dis;
        
        vis[i][j]=true;
        int ans=Integer.MAX_VALUE;
        ans=Math.min(ans,dfs(grid,vis,i+1,j,dis+1));
        ans=Math.min(ans,dfs(grid,vis,i-1,j,dis+1));
        ans=Math.min(ans,dfs(grid,vis,i,j+1,dis+1));
        ans=Math.min(ans,dfs(grid,vis,i,j-1,dis+1));
        
        vis[i][j]=false;
        
        return ans;
        
    }
    
    
}