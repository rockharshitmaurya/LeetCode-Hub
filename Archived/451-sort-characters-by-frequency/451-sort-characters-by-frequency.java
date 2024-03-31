class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        ArrayList<ArrayList<Character>> list=new ArrayList<>();
        
        for(int i=0; i<=s.length(); i++){
            list.add(new ArrayList<>());
        }
        
        for(Character ch:map.keySet()){
            list.get(map.get(ch)).add(ch);
        }
        StringBuilder sb=new StringBuilder();
        
        for(int i=list.size()-1; i>=0; i--){
            if(list.get(i).size()==0) continue;
            
            
            for(char ch:list.get(i)){
                int count=i;
                while(count-->0){
                    sb.append(ch);
                }
            }
        }
        // System.out.println(list);
        return sb.toString();
    }
}
// [[],[],[],[]]

// [0,1,2,3]