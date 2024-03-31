class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        Queue<int[]> q=new LinkedList<>();
        int n=image.length,m=image[0].length;
        q.offer(new int[]{sr,sc});
        int dirs[][]={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int x=q.peek()[0];
            int y=q.poll()[1];
            int val=image[x][y];
            image[x][y]=color;
            for(int arr[]:dirs){
                int nrow=x+arr[0];
                int ncol=y+arr[1];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==val && image[nrow][ncol]!=color){
                    q.offer(new int[]{nrow,ncol});
                }
            }
        }
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         if(image[i][j]==-1) image[i][j]=color;
        //     }
        // }
        return image;
    }
}