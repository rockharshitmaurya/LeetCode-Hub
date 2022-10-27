class Solution {
    public int minMutation(String start, String end, String[] bank) {
       return  wordLadderLength(start,end,bank); 
    }
    
    class Pair{
        String w;
        int len;
        Pair(String _w,int _len){
            this.w=_w;
            this.len=_len;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        HashSet<String> set=new HashSet<>();
        for(String w:wordList){
            set.add(w);
        }
        
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(startWord,1));
        while(!q.isEmpty()){
            Pair word=q.poll();
            if(word.w.equals(targetWord)){
                return word.len-1;
            }
            helper(word,q,set);
        }
        return -1;
    }
    
    void helper(Pair p,Queue<Pair> q,HashSet<String> set){
        for(int i=0; i<p.w.length(); i++){
            StringBuilder sb=new StringBuilder(p.w);
            for(char ch:"ACGT".toCharArray()){
                sb.setCharAt(i,ch);
                String new_str=sb.toString();
                if(set.contains(new_str)){
                    set.remove(new_str);
                    q.offer(new Pair(new_str,p.len+1));
                }
            }
        }
    }

}