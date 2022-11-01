class Solution {

    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new int[] { i, 0, i });
        }
        // q.offer(new int[]{4,0,4});

        while (!q.isEmpty()) {
            int me = q.peek()[0];
            int i = q.peek()[1];
            int j = q.poll()[2];
            // System.out.println(i+" "+j);
            if(i==m){
                ans[me]=j;
                continue;
            }
            
            if (grid[i][j] == 1) {
                int x = i + 1;
                int y = j + 1;
                
                if(j+1==n || grid[i][j+1]!=grid[i][j]) continue;
                
                q.offer(new int[]{me,x,y});
                
            } else {
                int x = i + 1;
                int y = j - 1;
                if(j-1<0 || grid[i][j-1]!=grid[i][j]) continue;
                
                q.offer(new int[]{me,x,y});
                
            }
        }
        return ans;
    }
}
//  [1,1,1,1,1,1],
// [-1,-1,-1,-1,-1,-1]
//  [1,1,1,1,1,1],
// [-1,-1,-1,-1,-1,-1]]
