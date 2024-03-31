class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx=binarySearch(nums,target,0,nums.length-1);
        int start=idx,end=idx,call_a=idx,call_b=idx;
        
        while(call_a!=-1 || call_b!=-1){
            
            if(call_a!=-1) {
                call_a=binarySearch(nums,target,0,call_a-1);
                if(call_a!=-1) start=call_a;
            }
            
            if(call_b!=-1){
                call_b=binarySearch(nums,target,call_b+1,nums.length-1);
                if(call_b!=-1) end=call_b;
            }
        }
        // System.out.println(idx);
       return new int[]{start,end}; 
    }
    int binarySearch(int nums[],int target,int l,int r){
        if(l<=r){
            int mid=(l+r)>>1;
            if(nums[mid]==target) return mid;
            
            if(nums[mid]<target) return binarySearch(nums,target,mid+1,r);
            
            return binarySearch(nums,target,l,mid-1);
        }
        return -1;
    }
}