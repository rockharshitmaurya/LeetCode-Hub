class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words,(o1,o2)->(o1.length()-o2.length()));
        HashMap<String,Integer> map=new HashMap<>();
        // System.out.println(Arrays.toString(words));
        String ans="";
        for(String word:words){
            if(word.length()==1){
                map.put(word,1);
                if(word.length()>ans.length()) ans=word;
                    if(word.length()==ans.length()){
                        if(word.compareTo(ans)<0) ans=word;
                    } 
                // continue;
            }
                String org_word=word.substring(0,word.length()-1);
                // word=word.substring(0,word.length()-1);
                if(map.containsKey(org_word)){
                    map.put(word,1);
                    if(word.length()>ans.length()) ans=word;
                    if(word.length()==ans.length()){
                        if(word.compareTo(ans)<0) ans=word;
                    } 
                }
            
        }
        
      return ans;
    }
}