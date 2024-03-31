class Solution {

    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0, ans = 0;
        for (int num : nums) {
            
            sum = (sum + num % k + k) % k;
            ans += map.getOrDefault(Math.abs(sum % k), 0);
            // map.put(sum, map.getOrDefault(sum, 0) + 1);
            map.put(sum%k, map.getOrDefault(sum%k, 0) + 1);
        }
        
        return ans;
    }
}
