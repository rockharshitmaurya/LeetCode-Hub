class Solution {
    int dp[];

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return helper(nums, target);
    }

    int helper(int nums[], int target) {
        if (target < 0) return 0; else if (target == 0) return 1;

        if (dp[target] != -1) return dp[target];

        int add = 0;
        for (int i = 0; i < nums.length; i++) {
            add += helper(nums, target - nums[i]);
        }

        return dp[target] = add;
    }
}
