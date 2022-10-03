class Solution {
    public int longestSubarray(int[] nums) {
        int result=0,length=0,max=Arrays.stream(nums).max().getAsInt();
        for(int ele:nums){
            if(ele==max) length++;
            else length=0;
            result=Math.max(result,length);
        }
        
        return result;
    }
}