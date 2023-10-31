class Solution {
    public int[] findArray(int[] pref) {
        int ans=0,prev=0;
        for(int i=0; i<pref.length; i++){
            prev=pref[i];
            pref[i]=ans^pref[i];
            ans=prev;
        }
        
        return pref;
    }
}