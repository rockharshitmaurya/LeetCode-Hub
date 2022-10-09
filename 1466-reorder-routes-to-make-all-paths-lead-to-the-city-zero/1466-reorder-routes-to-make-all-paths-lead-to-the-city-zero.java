class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<int[]> adj[]=new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i]=new ArrayList<int[]>();
        }
        for(int arr[]:connections){
            adj[arr[0]].add(new int[]{arr[1],1});
            adj[arr[1]].add(new int[]{arr[0],0});
        }
        
       boolean vis[]=new boolean[n];
        
        return helper(adj,vis,0);
    }
    
    int helper(ArrayList<int[]> adj[],boolean vis[],int node){
        vis[node]=true;
        
        int count=0;
        for(int arr[]:adj[node]){
            if(!vis[arr[0]]){
                count+=(arr[1]+helper(adj,vis,arr[0]));
            }
        }
        
        return count;
    }
}