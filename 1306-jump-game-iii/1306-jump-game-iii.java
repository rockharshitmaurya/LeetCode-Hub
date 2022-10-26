class Solution {
    public boolean canReach(int[] arr, int start) {
       int n=arr.length;
       boolean vis[]=new boolean[n];
       return helper(arr,start,vis);
    }
    
    boolean helper(int arr[],int idx,boolean vis[]){
        if(idx<0 || idx>=arr.length || vis[idx]) return false;
        if(arr[idx]==0) return true;
        vis[idx]=true;
        
        return helper(arr,idx+arr[idx],vis) ||
        helper(arr,idx-arr[idx],vis);
    }
}