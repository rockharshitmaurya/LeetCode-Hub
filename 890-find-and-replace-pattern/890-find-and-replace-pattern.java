class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> ans=new ArrayList<>();
        pattern=normalize(pattern);
        for(String str:words){
            String nor_str=normalize(str);
            if(nor_str.equals(pattern)){
                ans.add(str);
            }
        }
        return ans;
    }
    String normalize(String str){
        
        HashMap<Character,Integer> map=new HashMap<>();
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0; i<str.length(); i++){
              char ch=str.charAt(i);
              if(!map.containsKey(ch)) map.put(ch,i);
              sb.append(map.get(ch));
            
        }
        return sb.toString();
    }
}

    
