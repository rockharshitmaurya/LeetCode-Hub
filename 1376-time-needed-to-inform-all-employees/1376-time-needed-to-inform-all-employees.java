class Solution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] in_time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) continue;
            adj.get(manager[i]).add(i);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { headID, 0 });
        int ans = 0;
        while (!q.isEmpty()) {
            int root = q.peek()[0];
            int time = q.poll()[1];
            ans = Math.max(ans, time);
            for (int child : adj.get(root)) {
                q.offer(new int[] { child, time + in_time[root] });
            }
        }

        return ans;
    }
}
