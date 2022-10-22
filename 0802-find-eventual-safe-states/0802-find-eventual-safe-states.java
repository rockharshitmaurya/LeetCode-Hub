class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        return eventualSafeNodes(graph.length,graph);
    }
    List<Integer> eventualSafeNodes(int V,int[][] adj) {
        boolean vis[]=new boolean[V];
        boolean pathVis[]=new boolean[V];
        
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(adj,i,vis,pathVis);
            }
        }
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0; i<V; i++){
            if(!pathVis[i]){
                ans.add(i);
            }
        }
        return ans;
    }
    
    boolean dfs(int[][] adj,int root,boolean[] vis,boolean[] pathVis){
        vis[root]=true;
        pathVis[root]=true;
        
        for(int child:adj[root]){
            if(!vis[child]){
                if(dfs(adj,child,vis,pathVis)) return true;
            }else if(pathVis[child]){
                return true;
            }
        }
        pathVis[root]=false;
        return false;
    }
}