class CombinationIterator {
    ArrayList<String> pq=new ArrayList<>();
    public CombinationIterator(String ch, int cl) {
        helper(ch,cl,0,"");
    }
    public void helper(String ch,int cl,int idx, String str){
        if(idx==ch.length()){
            if(str.length()==cl) pq.add(str);
            return;
        }
        str+=ch.charAt(idx)+"";
        helper(ch,cl,idx+1,str);
        str=str.substring(0,str.length()-1);
        helper(ch,cl,idx+1,str);
    }
    public String next() {
       return pq.remove(0); 
    }
    
    public boolean hasNext() {
        return !pq.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */