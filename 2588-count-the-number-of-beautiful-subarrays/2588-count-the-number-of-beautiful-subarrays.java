class Solution {
    public long beautifulSubarrays(int[] nums) {
        long count=0;
        HashMap<Long,Long> map=new HashMap<>();
        map.put(0L,1L);
        long xor=0;
        
        for(int num:nums){
            xor^=num;
            if(map.containsKey(xor)) count+=map.get(xor);
            map.put(xor,map.getOrDefault(xor,0L)+1L);
        }
        
        return count;
    }
}