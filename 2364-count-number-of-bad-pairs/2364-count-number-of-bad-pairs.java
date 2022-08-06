class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        long ans=0;
        
        for(int i=0; i<nums.length; i++){
            int diff=map.getOrDefault(i-nums[i],0);
            ans+=(i-diff);
            map.put(i-nums[i],diff+1);
        }
        return ans;
    }
}