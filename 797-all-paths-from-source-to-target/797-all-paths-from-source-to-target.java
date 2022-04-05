class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> help=new ArrayList<>();
        Queue<List<Integer>> q=new LinkedList<>();
        help.add(0);
        q.offer(help);
        while(!q.isEmpty()){
           help=q.poll();
            int v=help.get(help.size()-1);
            if(v==graph.length-1){
                ans.add(help);
                continue;
            }
            for(int i:graph[v]){
                ArrayList<Integer> temp=new ArrayList<>(help);
                temp.add(i);
                q.offer(temp);
            }
        }
        return ans;
    }
}