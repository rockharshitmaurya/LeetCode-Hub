class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int idx=nums.length/2;
        int ans=0;
        for(int i=0; i*2<nums.length; i++){
            ans+=Math.abs(nums[idx]-nums[i]);
            ans+=Math.abs(nums[idx]-nums[nums.length-i-1]);
        }
      return ans;  
    }
}