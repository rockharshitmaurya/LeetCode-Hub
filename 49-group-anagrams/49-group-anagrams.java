class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        
        
        for(String str:strs){
            String key;
            int count[]=new int[26];
            for(char ch:str.toCharArray()){
                count[ch-'a']++;
            } key=Arrays.toString(count);           
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(str);
        }
        
        List<List<String>> ans=new ArrayList<>();
        
        for(ArrayList<String> sub:map.values()){
            ans.add(sub);
        }
        
        return ans;
    }
}