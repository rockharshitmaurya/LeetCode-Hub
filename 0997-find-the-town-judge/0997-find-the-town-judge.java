class Solution {
    public int findJudge(int n, int[][] trust) {
        int ind[]=new int[n+1];
        int out[]=new int[n+1];
        for(int arr[]: trust){
            ind[arr[1]]++; out[arr[0]]++;
        }
        
        for(int i=1; i<=n; i++){
            if(ind[i]==n-1 && out[i]==0) return i;
        }
        
        return -1;
    }
}