class Solution {
    public int minimumOperations(int[] nums) {
        int count[]=new int[101];
        
        for(int num:nums){
            count[num]=num;
        }
        
        int ans=0;
        
        for(int num:count) if(num!=0) ans++;
        
        return ans;
    }
}