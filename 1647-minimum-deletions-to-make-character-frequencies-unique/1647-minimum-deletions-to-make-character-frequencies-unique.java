class Solution {
    public int minDeletions(String s) {
        int count[]=new int[26];
        for(char ch:s.toCharArray()) count[ch-'a']++;
        Arrays.sort(count);
        int ans=0;
        for(int i=24; i>=0; i--){
            if(count[i]==0) break;
            // if(count[i]==count[i+1]){
                while(isExist(count,count[i],i)){
                    count[i]--;
                    ans++;
                    if(count[i]==0)  break;
                }
            // }
        }
        return ans;
    }
    boolean isExist(int count[],int val,int idx){
        for(int i=idx+1; i<26; i++){
            if(count[i]==val) return true;
        }
        return false;
    }
}