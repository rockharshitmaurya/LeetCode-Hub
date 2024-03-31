class Solution {
    public int[] sortArray(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);
        
        int idx=0;
        
        for(int key:map.keySet()){
            int val=map.get(key);
            while(val-->0) nums[idx++]=key;
        }
        return nums;
    }
}