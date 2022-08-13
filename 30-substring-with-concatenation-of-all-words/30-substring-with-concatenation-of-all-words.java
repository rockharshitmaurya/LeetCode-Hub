class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int strLen=words[0].length();
        HashMap<String,Integer> map=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        int len=((strLen*words.length));
        for(int i=0; i<=(s.length()-len); i++){
            String sub=s.substring(i,i+len);
            if(check(map,sub,strLen)){
                ans.add(i);
            }
        }
        return ans;
    }
    boolean check(HashMap<String,Integer> map,String str,int len){
        HashMap<String ,Integer> temp=new HashMap<>();
        for(int i=0; i<str.length(); i+=len){
            String word=str.substring(i,i+len);
            temp.put(word,temp.getOrDefault(word,0)+1);
        }
        return map.equals(temp);
    }
}