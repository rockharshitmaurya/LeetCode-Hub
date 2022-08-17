class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set=new HashSet<>();
        String arr[]=".-,-...,-.-.,-..,.,..-.,--.,....,..,.---,-.-,.-..,--,-.,---,.--.,--.-,.-.,...,-,..-,...-,.--,-..-,-.--,--..".split(",");
        
        for(String word:words){
            String ans="";
            for(char ch:word.toCharArray()){
                ans+=arr[ch-'a'];
            }
            set.add(ans);
        }
        return set.size();
    }
}