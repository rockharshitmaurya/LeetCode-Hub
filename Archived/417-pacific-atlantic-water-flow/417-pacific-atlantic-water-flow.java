class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                if(dfs(heights,i,j,heights[i][j],new HashSet<>()).size()==2){

                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(i); temp.add(j); ans.add(temp);
                }
                
            }
        }
        return ans;
    }
 
    HashSet<String> dfs(int[][] heights,int i,int j,int num,HashSet<String> set){
        if(set.size()==2) return set;
        if(i<0 || j<0){
            set.add("Pacific");
            return set;
        }else if(i==heights.length || j==heights[0].length){
            set.add("Atlantic");
            return set;
        }
        if(heights[i][j]!=-1 && heights[i][j]<=num){
            int store=heights[i][j];
            heights[i][j]=-1;
            dfs(heights,i,j+1,store,set);
            dfs(heights,i+1,j,store,set);
            dfs(heights,i,j-1,store,set);
            dfs(heights,i-1,j,store,set);
            heights[i][j]=store;
        }  
        return set;
    }
}