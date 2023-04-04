class Solution {
    public int partitionString(String s) {
        int count=0;
        
        HashSet<Character> set=new HashSet<>();
        
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                count++;
                set.clear();
            }
            set.add(ch);
        }
        
        
        return count + 1; 
    }
}