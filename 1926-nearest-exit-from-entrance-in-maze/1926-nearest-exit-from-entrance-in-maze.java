class Solution {

    public int nearestExit(char[][] maze, int[] en) {
        Queue<int[]> q = new LinkedList<>();
        int n = maze.length, m = maze[0].length;
        q.offer(new int[] { en[0], en[1], 0 });
        maze[en[0]][en[1]]='+';
        int dirs[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.peek()[1];
            int dis = q.poll()[2];
            // maze[i][j]='+';
            for (int arr[] : dirs) {
                int x = i + arr[0];
                int y = j + arr[1];

                if (x < 0 || x == n || y < 0 || y == m) if (dis > 0) return dis; 
                else continue;

                if (maze[x][y] == '+') continue;
                maze[x][y] = '+';
                q.offer(new int[] { x, y, dis + 1 });
            }
        }

        return -1;
    }
}

// [["+",".","+","+","+","+","+"],
//  ["+",".","+",".",".",".","+"],
//  ["+",".","+",".","+",".","+"],
//  ["+",".",".",".","+",".","+"],
//  ["+","+","+","+","+",".","+"]]
// [0,1]