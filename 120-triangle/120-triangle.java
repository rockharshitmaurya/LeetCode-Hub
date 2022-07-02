class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> memo=new ArrayList<>();
        for(int i=0; i<triangle.size(); i++){
            memo.add(new ArrayList<Integer>(Collections.nCopies(triangle.get(i).size(), -1)));
        }
        return helper(triangle,0,0,memo);
    }
    int helper(List<List<Integer>> triangle,int level,int idx,List<List<Integer>> memo){
        if(level==triangle.size()-1) return triangle.get(level).get(idx);
        if(memo.get(level).get(idx)!=-1) return memo.get(level).get(idx);
        int dwn=triangle.get(level).get(idx)+helper(triangle,level+1,idx,memo);
        int dig=triangle.get(level).get(idx)+helper(triangle,level+1,idx+1,memo);
        memo.get(level).add(idx,Math.min(dwn,dig));
        return Math.min(dwn,dig);
    }
}