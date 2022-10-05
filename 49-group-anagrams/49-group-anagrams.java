class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        
        
        for(String str:strs){
            String key;
            char count[]=new char[26];
            for(char ch:str.toCharArray()){
                count[ch-'a']++;
            } key=String.valueOf(count);           
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}