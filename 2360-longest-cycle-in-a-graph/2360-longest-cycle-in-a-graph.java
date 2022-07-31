class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        int dis[]=new int[n];
        int ans=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            ans=Math.max(ans,helper(edges,i,dis,0));
        }
        return ans;
            
    }
    int helper(int graph[],int root,int going[],int len){
        
        if(root==-1 || going[root]==-1) return -1;
        
        if(going[root]!=0) return len-going[root];
            // vis[root]=true;
            int val=-1; going[root]=len;
            // for(int child:graph.get(root)){
                val=Math.max(val,helper(graph,graph[root],going,len+1));
            // }
            // vis[root]=false;
        going[root]=-1;
        return val;
    }
}