class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int count[]=new int[26];
        
        for(char ch:ransomNote.toCharArray()){
            count[ch-'a']++;
        }
        for(char ch:magazine.toCharArray()){
            count[ch-'a']--;
        }
        for(int num:count){
            if(num>0) return false;
        }
        return true;
    }
}