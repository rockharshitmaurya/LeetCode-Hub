class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len=nums.length+1,sum=0;
        boolean flag=false;
        int i=0,j=0;
        while(i<nums.length){
            while(i<nums.length && sum<target){
                sum+=nums[i++];
                // len=Math.min(len,(i-j)+1);
              
            }
            
            while(j<i && sum>=target){
                sum-=nums[j++];
                len=Math.min(len,(i-j)+1);
                // System.out.println(sum+" j ");
            }
            
        }
        return len==nums.length+1?0:len;
        
    }
}