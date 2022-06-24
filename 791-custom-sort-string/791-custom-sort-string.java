class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder ans=new StringBuilder();
        for(char c:order.toCharArray()){
            if(!map.containsKey(c)) continue;
            int k=map.get(c);
            map.remove(c);
            while(k-->0) ans.append(c);
        }
        for(Map.Entry<Character,Integer> mp:map.entrySet()){
            char ch=mp.getKey(); int k=mp.getValue();
            while(k-->0) ans.append(ch);
        }
     return String.valueOf(ans);   
    }
}