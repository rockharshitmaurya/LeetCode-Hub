class Solution {

    public int longestSubsequence(int[] nums, int diff) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans=0;
        for (int num : nums) {
            int find = num - diff;
            dp.put(num, dp.getOrDefault(find, 0) + 1);
            ans=Math.max(ans,dp.get(num));
        }
        return ans;
    }
    
}
