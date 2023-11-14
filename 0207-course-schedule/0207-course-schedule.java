class Solution {

    public boolean canFinish(int n, int[][] pre) {
        int ind[] = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < pre.length; i++) {
            ind[pre[i][0]]++;
            adj.get(pre[i][1]).add(pre[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (ind[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : adj.get(node)) {
                if (--ind[child] == 0) {
                    q.offer(child);
                }
            }
        }
        for(int i=0; i<n; i++){
            if(ind[i]!=0) return !true;
        }
        // System.out.println(Arrays.toString(ind));
        return true;
    }
}
