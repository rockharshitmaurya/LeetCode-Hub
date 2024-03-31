class Solution {
    class Pair{
        String word;
        int len=0;
        Pair(String w,int l){
            word=w;
            len=l;
        }
    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> set=new HashSet<>();
        for(String word:deadends) set.add(word);

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair("0000",0));
        
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            if(set.contains(p.word)) continue;
            if(p.word.equals(target)) return p.len;
            set.add(p.word);
            
            StringBuilder sb=new StringBuilder(p.word);
            
            for(int i=0; i<4; i++){
                char cur=sb.charAt(i);
                sb.setCharAt(i,inc(cur));
                // if(!set.contains(sb.toString())){
                    q.offer(new Pair(sb.toString(),p.len+1));
                    // set.add(sb.toString());
                // }
                
                sb.setCharAt(i,dec(cur));
                // if(!set.contains(sb.toString())){
                    q.offer(new Pair(sb.toString(),p.len+1));
                    // set.add(sb.toString());
                // }
                
                sb.setCharAt(i,cur);
            }
            
        }
        
        return -1;
    }
    
    char inc(char ch){
        return ch=='9'?'0':++ch;
    }
    char dec(char ch){
        return ch=='0'?'9':--ch;
    }
}