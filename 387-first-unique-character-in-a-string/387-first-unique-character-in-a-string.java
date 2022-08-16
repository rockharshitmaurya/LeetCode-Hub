class Solution {
    public int firstUniqChar(String s) {
        int count[]=new int[26];
        
        for(char ch:s.toCharArray()){
            if(count[ch-'a']==-1 || count[ch-'a']>0){
                count[ch-'a']=-1;
            }else{
                count[ch-'a']++;
            }
        }
//         char ch='1';
//         for(int i=0; i<26; i++){
//             if(count[i]>0){
//                 ch = (char) (i+'a');
//                 break;
//             }
//         }
        
//         if(ch=='1') return -1;
        // System.out.println()
        for(int i=0; i<s.length(); i++){
            if(count[s.charAt(i)-'a']>0) return i;
        }
        return -1;
    }
}