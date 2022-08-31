class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean vis[][]=new boolean[heights.length][heights[0].length];
        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                if(dfs(heights,i,j,heights[i][j],new HashSet<>(),vis).size()==2){
                    vis[i][j]=true;
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(i); temp.add(j); ans.add(temp);
                }
                // if(i==0 && j==0) System.out.println("0,0 End");
            }
        }
        // System.out.println(Arrays.deepToString(heights));
        return ans;
    }
    
    HashSet<String> dfs(int[][] heights,int i,int j,int num,HashSet<String> set,boolean vis[][]){
        // System.out.println(i+" "+j);
        if(set.size()==2) return set;
        if(i<0 || j<0){
            set.add("Pacific");
            return set;
        }else if(i==heights.length || j==heights[0].length){
            set.add("Atlantic");
            return set;
        }
        // if(heights[i][j]!=-1 && heights[i][j]<=num && vis[i][j]==true){
        //     set.add("A"); set.add("P");
        //     return set;
        // }        
        if(heights[i][j]!=-1 && heights[i][j]<=num){
            int store=heights[i][j];
            heights[i][j]=-1;
            dfs(heights,i,j+1,store,set,vis);
            dfs(heights,i+1,j,store,set,vis);
            dfs(heights,i,j-1,store,set,vis);
            dfs(heights,i-1,j,store,set,vis);
            heights[i][j]=store;
        }  
        return set;
    }
}