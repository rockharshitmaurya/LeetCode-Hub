class Solution {
        int dfs(ArrayList<ArrayList<int[]>> graph,int root,int weight[],int min){
        int min_ans=Integer.MAX_VALUE;
        for(int arr[]:graph.get(root)){
           if(Math.min(min,arr[1])<weight[arr[0]]) {
               weight[arr[0]]=Math.min(min,arr[1]);
               int val =Math.min(arr[1],dfs(graph,arr[0],weight,weight[arr[0]]));
               min_ans = Math.min(min_ans,val);
           }
        }
        return min_ans;
    }
    public int minScore(int n, int[][] roads) {
            
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
        
        for(int i=0; i<(n+1); i++) {
            graph.add(new ArrayList<>());
        }
        for(int arr[]:roads){
            graph.get(arr[0]).add(new int[]{arr[1],arr[2]});
            graph.get(arr[1]).add(new int[]{arr[0],arr[2]});
        }
        int weight[]=new int[n+1];
        Arrays.fill(weight,(int)1e9);
        weight[1]=0;
        return dfs(graph,1,weight,(int)1e9);
    }
    

}