class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int i=0,next=0;
        while(i<n && i<=next){
            next=Math.max(i+nums[i],next);
            i++;
        }
        return i==n;
    }
}




