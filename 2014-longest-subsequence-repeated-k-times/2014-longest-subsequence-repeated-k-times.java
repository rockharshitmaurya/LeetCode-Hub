class Solution {

    public String longestSubsequenceRepeatedK(String s, int k) {
        Queue<String> q=new LinkedList<>();
        String ans="";
        q.offer("");
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String str=q.poll();
                for(char ch='a'; ch<='z'; ch++){
                    String new_str=str+ch;
                    if(ok(s,new_str,k)){
                        ans=new_str;
                        q.offer(new_str);
                    }
                }
            }
        }
        return ans;
    }

    boolean ok(String s, String sub, int k) {
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
                if (sub.length() == j) {
                    k--;
                    if (k == 0) return true;
                    j = 0;
                }
            }
        }

        return false;
    }
}
