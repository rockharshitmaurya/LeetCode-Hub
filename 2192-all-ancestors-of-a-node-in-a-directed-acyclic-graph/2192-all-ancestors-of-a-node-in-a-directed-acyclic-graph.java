class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        List<TreeSet<Integer>> ans=new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
            ans.add(new TreeSet<>());  
        }
        int ind[]=new int[n];
        
        for(int arr[]:edges){
            adj.get(arr[0]).add(arr[1]);
            ind[arr[1]]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0; i<n; i++){
            if(ind[i]==0) q.offer(i);
        }
        
        ArrayList<Integer> topo=new ArrayList<>();
        
        while(!q.isEmpty()){
            int node=q.poll();
            topo.add(node);
            
            for(int child:adj.get(node)){
                ans.get(child).add(node);
                ans.get(child).addAll(ans.get(node));
                if(--ind[child]==0){
                    q.offer(child);
                }
            }
        }
        adj.clear();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>(ans.get(i)));
        }
        return adj;
    }
}

// [27, 12, 23, 25, 4, 0, 16, 32, 17, 8, 2, 10, 22, 14, 21, 31, 26, 19, 24, 5, 15, 20, 30, 18, 11, 33, 1, 6, 28, 9, 29, 3, 7, 13]
