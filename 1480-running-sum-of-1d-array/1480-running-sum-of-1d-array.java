class Solution {
    public int[] runningSum(int[] nums) {
        int prev=0;
        for(int i=0; i<nums.length; i++){
            prev =prev + nums[i];
            nums[i]=prev;
        }
        return nums;
    }
}