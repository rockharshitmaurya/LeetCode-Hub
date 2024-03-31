class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int size=0;
        for(int i=0; i<n; i++){
            int idx=Arrays.binarySearch(dp,0,size,nums[i]);
            if(idx < 0) idx = -(idx + 1); //trick copied
            dp[idx]=nums[i];
            System.out.print(idx+" ");
            if(idx==size) size++;
            
        }
        return size;
    }
}