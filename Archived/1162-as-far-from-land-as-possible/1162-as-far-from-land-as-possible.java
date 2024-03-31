class Solution {
    int INF=(int)1e5;
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        Queue<int[]> q=new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1) q.offer(new int[]{i,j,0});
            }
        }
        int ans=-1;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!q.isEmpty()){
            int i=q.peek()[0];
            int j=q.peek()[1];
            int dis=q.poll()[2];
            for(int arr[]:dirs){
                int x=i+arr[0];
                int y=j+arr[1];
                int new_dis=dis+1;
                if(x<0 || x==n || y<0 || y==n || grid[x][y]!=0) continue;
                ans=Math.max(ans,new_dis);
                grid[x][y]=-1; //visited
                q.offer(new int[]{x,y,new_dis});
            }
        }
        System.out.println(Arrays.deepToString(grid));
        return ans;
    }
}
// [0,0,1,1,1],
// [0,1,1,0,0],
// [0,0,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,1]


// [0, 2, 1, 1, 1],
// [2, 1, 1, 2, 2],
// [0, 2, 1, 1, 3],
// [1, 0, 2, 3, 0],
// [1, 1, 3, 0, 1]
