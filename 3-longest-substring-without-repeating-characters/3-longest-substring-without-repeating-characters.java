class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int ans=0,seen=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch) && map.get(ch)>=seen){
                int idx=map.get(ch);
                seen=idx+1;
                System.out.println(seen);
            }else{
                ans=Math.max(ans,i-seen);
            }
                map.put(ch,i);
        }
        System.out.println(seen);
        return ans+1;
    }
}
// abcade
