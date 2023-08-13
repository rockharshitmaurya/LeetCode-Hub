class Solution {

    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();

        int n = nums.size();

        int ans = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            set.add(nums.get(i));
            if (i + x >= n) break;
            if (set.contains(nums.get(i + x))) return 0;

            // if(map.higher(nums[]))
            Integer higher = set.higher(nums.get(i + x));
            Integer lower = set.lower(nums.get(i + x));
            if(higher!=null) ans=Math.min(ans,higher-nums.get(i + x));
            if(lower!=null) ans=Math.min(ans,nums.get(i + x)-lower);  
        }
        
        return ans;
    }
}
