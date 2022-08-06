class Solution {
    public long minimumReplacement(int[] nums) {
        long ans=0,prev=nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            long count=nums[i]/prev;
            // System.out.println(count+" "+nums[i]+" "+prev);
            if(nums[i]%prev!=0){
                count++;
                prev=nums[i]/count;
            }
            ans+=(count)-1;
        }
        return ans;
    }
}