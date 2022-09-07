class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer> graph[]=new ArrayList[n];
        
        for(int i=0; i<n; i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int arr[]:edges){
            graph[arr[0]].add(arr[1]);
            graph[arr[1]].add(arr[0]);
        }
        
        return dfs(graph,destination,source,new boolean[n]);
        
      // return true;  
    }
    
    boolean dfs(ArrayList<Integer> graph[],int d,int root,boolean vis[]){
        if(root==d) return true;
        
        vis[root]=true;
        
        
        for(int num:graph[root]){
            if(!vis[num]){
                if(dfs(graph,d,num,vis)) return true;
            }
        }
        
        
        
        return false;
    }
}