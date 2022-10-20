class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
         dfs(0,graph,ans,new ArrayList<>(Arrays.asList(0)));
        
        return ans;
    }
    
    
    void dfs(int root,int[][] graph,List<List<Integer>> ans,ArrayList<Integer> temp){
        if(root==graph.length-1){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int child:graph[root]){
            temp.add(child);
            dfs(child,graph,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
    
}