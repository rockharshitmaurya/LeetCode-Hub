class Solution {
    public int minGroups(int[][] intervals) {
        int len=0;
        for(int arr[]:intervals){
            len = Math.max(len,arr[0]);
            len = Math.max(len,arr[1]);
        }
        int arr[]=new int[len+2];
        
        for(int sub[]:intervals){
            arr[sub[0]]++; arr[sub[1]+1]--;
        }
        
        for(int i=1; i<arr.length; i++){
            arr[i]+=arr[i-1];
        }
        
        int ans = 0 ;
        
        for(int num : arr) ans=Math.max(ans,num);
        return ans;
    }
}