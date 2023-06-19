class Solution {
    int MOD = (int) 1e9 + 7;
    int dp[][];

    public int specialPerm(int[] nums) {
        dp = new int[(int) Math.pow(2, nums.length + 1)][nums.length + 1];
        for (int arr[] : dp) Arrays.fill(arr, -1);
        return helper(nums, 0, 0, -1);
    }

    int helper(int nums[], int idx, int mask, int last) {
        if (idx == nums.length) return 1;

        if (last != -1 && dp[mask][last] != -1) return dp[mask][last];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) > 0) continue;
            if (last == -1 || nums[last] % nums[i] == 0 || nums[i] % nums[last] == 0) {
                ans = (ans + helper(nums, idx + 1, (mask | (1 << i)), i)) % MOD;
            }
        }
        if (last != -1) dp[mask][last] = ans;
        return ans;
    }
}
