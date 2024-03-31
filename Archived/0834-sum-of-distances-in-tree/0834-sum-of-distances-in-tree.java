class Solution {
    int res[],count[];
    ArrayList<HashSet<Integer>> adj=new ArrayList<>();
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        res=new int[n];
        count=new int[n];
        for(int i=0; i<n; i++)
            adj.add(new HashSet<>());
        for(int arr[]:edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        
        dfs(0,-1);
        dfs1(0,-1);
        return res;
    }
    
    void dfs(int root,int parent){
        
        for(int child:adj.get(root)){
            if(child!=parent){
                dfs(child,root);
                count[root]+=count[child];
                res[root]+=(res[child]+count[child]);
            }
        }
        count[root]++;
    }
    
    void dfs1(int root,int parent){
        
        for(int child:adj.get(root)){
            if(child!=parent){
                res[child] = res[root]-count[child]+count.length-count[child];
                dfs1(child,root);
            }
        }
    }
}