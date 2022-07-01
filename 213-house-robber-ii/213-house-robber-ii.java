class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int first[]=new int[n-1];
        int last[]=new int[n-1];
        //since we know that the house are arrenged in circulr order there by we know that we can not have first and the last element of the array togather ,so-->
        for(int i=0; i<n; i++){
            if(i!=0) first[i-1]=nums[i]; //once we ignore the first element and copy rest of the element in onther array
            if(i!=n-1) last[i]=nums[i]; // and make one another array in which we add all the element except tha last elemnt of ate array 
        }
        return Math.max(helper(nums,1,n),helper(nums,0,n-1)); //now we apply same logic as house robber 1 problm and return the max of them
        
    }
    int helper(int nums[],int l,int r){
        int prev=nums[l];
        int prev2=0;
        for(int i=l; i<r; i++){
            int take=nums[i]+((i>(l+1))?prev2:0);
            int notTake=0+prev;
            int cur=Math.max(take,notTake);
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
}