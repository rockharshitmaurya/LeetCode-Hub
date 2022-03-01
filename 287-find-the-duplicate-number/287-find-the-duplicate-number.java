class Solution {
    public int findDuplicate(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int count=0;
            for(int val:nums){
                if(val<=mid) count++;
            }
            if(count<=mid) l=mid+1;
            else r=mid-1;
        }
        return l;
    }
}