class Solution {
    int INF=(int)1e9;
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        int[][] ans=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j,0});
                }else{
                    ans[i][j]=INF;
                }
            }
        }
        int dirs[][]={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int i=q.peek()[0];
            int j=q.peek()[1];
            int dis=q.poll()[2];
            
            
            for(int arr[]:dirs){
                int x=i+arr[0];
                int y=j+arr[1];
                if(x<0 || y<0 || x==n || y==m) continue;
                
                if(dis+1<ans[x][y]){
                    ans[x][y]=dis+1;
                    q.offer(new int[]{x,y,dis+1});
                }
            }
            
        }
        
        
        return ans;
    }
}
// [[0,0,0],
//  [0,1,0],
//  [1,1,1]]