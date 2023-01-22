class Solution {
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        helper(s,0,0,ans,new ArrayList<>());
        return ans;
    }
    
    void helper(String s,int idx,int start,List<List<String>> ans,ArrayList<String> ds){
        if(idx==s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=idx; i<s.length(); i++){
            if(ok(s,start,i)){
                ds.add(s.substring(start,i+1));
                helper(s,i+1,i+1,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    
    boolean ok(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}