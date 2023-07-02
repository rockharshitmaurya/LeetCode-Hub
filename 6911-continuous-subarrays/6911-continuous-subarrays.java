class Solution {

    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int left = 0, right = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int n = nums.length;

        while (right < n) {
            if (map.isEmpty() || Math.abs(map.firstKey() - nums[right]) <= 2 && Math.abs(map.lastKey() - nums[right]) <= 2) {
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                ans += ((right - left) + 1);
                right++;
                // System.out.println(left+"-->"+right);
            } else {
                // System.out.println(map.size());
                while (left < right && Math.abs(map.firstKey() - nums[right]) > 2 || Math.abs(map.lastKey() - nums[right]) > 2) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    if (map.get(nums[left]) == 0) map.remove(nums[left]);
                    left++;
                    // System.out.println(map.size());
                    if(map.size()==0) break;
                }
            }
            // System.out.println(map);
            
        }

        return ans;
    }
}
