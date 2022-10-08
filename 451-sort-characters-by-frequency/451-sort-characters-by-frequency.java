class Solution {
    class Pair{
        char ch;
        int count;
        Pair(char ch,int count){
            this.ch=ch;
            this.count=count;
        }
    }
    public String frequencySort(String s) {
       
       HashMap<Character,Pair> map=new HashMap<>();
        
      for(char ch:s.toCharArray()){
          if(!map.containsKey(ch)) map.put(ch,new Pair(ch,0));
          
          map.get(ch).count++;
      }
       ArrayList<Pair> list=new ArrayList<>(map.values()); 
        Collections.sort(list,(o1,o2)->(o2.count-o1.count));
        StringBuilder sb=new StringBuilder();
        for(Pair p:list){
            while(p.count>0){
                sb.append(p.ch); p.count--;
            }
        }
        return sb.toString();
    }
}
// eeeeaaaarrdcccc
// 4 - eeeecccc
// 3- aaa
// 2 -rr
// 1-d