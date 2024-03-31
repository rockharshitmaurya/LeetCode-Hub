class Solution {
    int INF=(int)1e9;
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,0}); //arr[0]->x ,arr[1]->y,arr[2]=cost
        int dis[][]=new int[n][m];
        int dir[][]={{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}};
        for(int arr[]:dis) Arrays.fill(arr,INF);
        dis[0][0]=0;
        while(!q.isEmpty()){
            int x=q.peek()[0];
            int y=q.peek()[1];
            int wt=q.poll()[2];
            
            for(int arr[]:dir){
                int row=x+arr[0],col=y+arr[1];
                if(row>=0 && row<n && col>=0 && col<m && grid[row][col]!=1){
                    if(wt+1<dis[row][col]){
                        dis[row][col]=wt+1;
                        q.offer(new int[]{row,col,dis[row][col]});
                    }
                }
            }
        }
        
        return dis[n-1][m-1]!=INF?dis[n-1][m-1]+1:-1;
    }
}