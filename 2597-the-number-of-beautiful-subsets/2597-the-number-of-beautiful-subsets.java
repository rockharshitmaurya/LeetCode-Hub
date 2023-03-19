class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    public int beautifulSubsets(int[] nums, int k) {
        return helper(nums,k,0)-1;
    }
    
    int helper(int nums[],int k,int idx){
        if(idx==nums.length){
            return 1;
        }
        int pick=0;
        if(map.containsKey(nums[idx]+k)==false && map.containsKey(nums[idx]-k)==false){
            map.put(nums[idx],map.getOrDefault(nums[idx],0)+1);
            pick=helper(nums,k,idx+1);
            if(map.get(nums[idx])==1) map.remove(nums[idx]);
            else map.put(nums[idx],map.get(nums[idx])-1);
        }
        int notpick=helper(nums,k,idx+1);
        return pick+notpick;
    }
}