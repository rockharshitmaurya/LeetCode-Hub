class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->(o1[2]-o2[2]));
        int n=heights.length;
        int m=heights[0].length;
        int INF=(int)1e9;
        int dis[][]=new int[n][m];
        
        int dirs[][]={{0,1},{1,0},{-1,0},{0,-1}};
        for(int arr[]:dis){
            Arrays.fill(arr,INF);
        }
        
        dis[0][0]=0;
        
        pq.offer(new int[]{0,0,0});
        
        while(!pq.isEmpty()){
            int x=pq.peek()[0];
            int y=pq.peek()[1];
            int wt=pq.poll()[2];
            
            for(int arr[]:dirs){
                int row=x+arr[0],col=y+arr[1];
                if(row>=0 && row<n && col>=0 && col<m){
                   if(Math.max(wt,Math.abs(heights[row][col]-heights[x][y]))<dis[row][col]){
                       dis[row][col]=Math.max(wt,Math.abs(heights[row][col]-heights[x][y]));
                       pq.offer(new int[]{row,col,dis[row][col]});
                   } 
                }
            }
        }
         return dis[n-1][m-1];
    }
}