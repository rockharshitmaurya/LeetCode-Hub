class Solution {
    public void moveZeroes(int[] nums) {
        int count=0,idx=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                count++;
            }else{
                nums[idx++]=nums[i];
            }
        }
        
        while(count-->0) nums[idx++]=0;
    }
}