class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++) if(nums[i]<k) map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        int ans=0;
        for(int num:nums){

            if(map.containsKey(num) && map.containsKey(k-num) && map.get(k-num)>0 && map.get(num)>0){
                if(num==k-num && map.get(num)<2) ans--;                 
            
                ans++;
             map.put(num,map.getOrDefault(num,0)-1);
             map.put(k-num,map.getOrDefault(k-num,0)-1);
            }
        }
        return ans;
    }
}