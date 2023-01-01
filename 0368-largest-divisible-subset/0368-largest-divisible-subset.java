class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int hash[] = new int[n];
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int last_idx = 0, max = 1;
        for (int i = 1; i < n; i++) {
            hash[i]=i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                last_idx = i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[last_idx]);
        while (hash[last_idx] != last_idx) {
            last_idx = hash[last_idx];
            ans.add(nums[last_idx]);
        }

        return ans;
    }
}
