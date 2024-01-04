class Solution {
    public int minOperations(int[] nums) {
int cnt = 0;
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int i: nums){
            hmap.put(i, hmap.getOrDefault(i, 0)+1);
        }

        for(Integer i: hmap.keySet()){
            double temp = hmap.get(i);
            if(temp == 1){
                return -1;
            }

            cnt += Math.ceil(temp/3); 
        }

        return cnt;
    }
}