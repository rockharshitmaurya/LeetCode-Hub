class Solution {
    class Pair{
        int start;
        int end;
        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Pair> map=new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new Pair(i,i));
            }else{
                if(Math.abs(map.get(nums[i]).end-i)<=k) return true;
                    
                map.get(nums[i]).end=i;
            }
        }
        return false;
    }
}