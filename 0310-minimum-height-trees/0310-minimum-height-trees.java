class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return new ArrayList<>(Arrays.asList(0));
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int ind[]=new int[n];
        
        for(int arr[]:edges){
            int u=arr[0],v=arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            ind[u]++; ind[v]++;
        }
        
        List<Integer> ans=new ArrayList<>();
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0; i<n; i++){
            if(ind[i]==1) q.offer(i);
        }
        
        while(!q.isEmpty()){
            n=q.size(); ans.clear();
            for(int i=0; i<n; i++){
                int node=q.poll();
                ans.add(node);
                for(int child:adj.get(node)){
                    if(--ind[child]==1){
                        q.offer(child);
                    }
                }
            }
        }
        return ans;
    }
}
