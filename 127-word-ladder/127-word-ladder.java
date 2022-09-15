class Solution {
    class Pair{
        String w;
        int len;
        Pair(String _w,int _len){
            this.w=_w;
            this.len=_len;
        }
    }
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String w:wordList){
            set.add(w);
        }
        
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(startWord,1));
        while(!q.isEmpty()){
            Pair word=q.poll();
            if(word.w.equals(targetWord)){
                return word.len;
            }
            helper(word,q,set);
        }
        return 0;
    }
    
    void helper(Pair p,Queue<Pair> q,HashSet<String> set){
        for(int i=0; i<p.w.length(); i++){
            StringBuilder sb=new StringBuilder(p.w);
            for(char ch='a'; ch<='z'; ch++){
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