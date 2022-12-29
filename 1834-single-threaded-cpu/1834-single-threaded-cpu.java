class Solution {

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int xtask[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            xtask[i] = new int[] { i, tasks[i][0], tasks[i][1] };
        }
        Arrays.sort(xtask, (o1, o2) -> (o1[1] - o2[1]));
        // System.out.println(Arrays.deepToString(xtask));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> {
                if (o1[2] == o2[2]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[2] - o2[2];
                }
            }
        );
        int idx = 0, limit = xtask[0][1];
        int ans[] = new int[n];
        int ans_idx = 0;
        while (idx < n) {
            while (idx < n && xtask[idx][1] <= limit) {
                pq.offer(xtask[idx++]);
            }
            
            int exc_time = 0;
            
            if(pq.isEmpty()){
                limit=xtask[idx][1];
                
                // pq.offer(xtask[idx++]);
                continue;
            }
            // while (!pq.isEmpty()) {
                // System.out.print(Arrays.toString(pq.peek())+" ");

                ans[ans_idx++] = pq.peek()[0];
                exc_time = pq.poll()[2];
            
            // }
            // System.out.println();
            limit+=exc_time;

        }
        while (!pq.isEmpty()) {
                // System.out.print(Arrays.toString(pq.peek())+" ");
                ans[ans_idx++] = pq.poll()[0];
                // exc_time = pq.poll()[2];
        }
        return ans;
    }
}
// [0,1,3,2]
// [1,3,2,0]
