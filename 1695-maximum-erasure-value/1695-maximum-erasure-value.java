class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int prefix[]=new int[nums.length];
        Map<Integer,Integer> map=new HashMap<>();
        int pre=0,max=0;
        int idx=-1,pidx=0;
        boolean found=false;
        for(int i=0; i<nums.length; i++){
            prefix[i]=pre+nums[i];
            pre+=nums[i];
            if(map.containsKey(nums[i])){
                int num=map.get(nums[i]); 
                idx=num<idx?idx:num;
            }
            if(idx==-1) max=prefix[i];
            else {
                max=Math.max(max,prefix[i]-prefix[idx]);
                pidx=idx;
            }
            // System.out.print(max+" ");
            map.put(nums[i],i);
        }
        System.out.println(Arrays.toString(prefix));
        return max;
    }
}