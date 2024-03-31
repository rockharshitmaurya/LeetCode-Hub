class Solution {

    class Tuple {
        int row;
        int col;
        int time;

        Tuple(int _row, int _col, int _time) {
            this.row = _row;
            this.col = _col;
            this.time = _time;
        }
    }

    int n, m;

    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Queue<Tuple> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Tuple(i, j, 0));
                }
            }
        }

        int ans = 0;

        while (!q.isEmpty()) {
            Tuple tp = q.poll();
            int row = tp.row;
            int col = tp.col;
            int time = tp.time;
            ans = Math.max(ans, time);
            if (isValid(row + 1, col, grid)) {
                q.offer(new Tuple(row + 1, col, time + 1));
            }
            if (isValid(row - 1, col, grid)) {
                q.offer(new Tuple(row - 1, col, time + 1));
            }
            if (isValid(row, col + 1, grid)) {
                q.offer(new Tuple(row, col + 1, time + 1));
            }
            if (isValid(row, col - 1, grid)) {
                q.offer(new Tuple(row, col - 1, time + 1));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }

    boolean isValid(int i, int j, int grid[][]) {
        if (i < 0 || j < 0 || i >= n || j >= m) return false;

        if (grid[i][j] == 1) {
            grid[i][j] = 2;
            return true;
        }
        return false;
    }
}
