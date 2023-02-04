class Solution {

    public int maximizeWin(int[] nums, int k) {
        int n = nums.length, start = 0, ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            while (nums[i] - nums[start] > k) {
                start++;
            }
            ans = Math.max(ans, i - start + 1 + (start > 0 ? dp[start - 1] : 0));
            dp[i] = Math.max((i > 0 ? dp[i - 1] : 0), i - start + 1);
        }
        return ans;
    }
}
