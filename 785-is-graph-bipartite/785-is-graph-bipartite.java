class Solution {
    public boolean isBipartite(int[][] graph) {
      int color[]=new int[graph.length];
      for(int i=0; i<graph.length; i++){
          if(color[i]==0 && !isValid(graph,color,1,i)) return false;
      }
        return true;
    }
    private boolean isValid(int[][] graph,int color[],int c,int node){
        if(color[node]!=0)
            return color[node]==c;
        color[node]=c;
        for(int n:graph[node]){
            if(!isValid(graph,color,-c,n)) return false;
        }
        return true;    
    }
}