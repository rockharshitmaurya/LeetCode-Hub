class Solution {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int ind[] = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int arr[] : richer) {
            // System.out.println(arr[1]+" "+n);
            adj.get(arr[0]).add(arr[1]);
            ind[arr[1]]++;
        }
        //toposort
        ArrayList<Integer> topo = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        int index = 0, ans[] = new int[n];
        Arrays.fill(ans,-1);
        for (int i = 0; i < n; i++) {
            if (ind[i] == 0) {
                q.offer(i);
                ans[i]=i;
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            
            for (int num : adj.get(node)) {
                if(ans[num]==-1){
                    ans[num]=num;
                }
                
                if(quiet[ans[node]]<quiet[ans[num]]){
                    ans[num]=ans[node];
                }
                if (--ind[num] == 0) {
                    q.offer(num);
                }
            }
        }
        //toposort end
        return ans;
    }
}
