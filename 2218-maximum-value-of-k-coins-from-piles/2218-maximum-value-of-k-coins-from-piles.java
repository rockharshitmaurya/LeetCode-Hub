class Solution {
    int dp[][];

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new int[piles.size()][k+1];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(piles, k, 0);
    }

    int helper(List<List<Integer>> piles, int k, int idx) {
        if (k == 0 || idx == piles.size()) return 0;

        if (dp[idx][k] != -1) return dp[idx][k];
        int sum = 0;
        int max =0;
        for (int i = 0; i < piles.get(idx).size(); i++) {
            if (k - (i + 1) < 0) continue;
            sum += piles.get(idx).get(i);
            max = Math.max(max, sum + helper(piles, k - (i + 1), idx + 1));
        }
        max=Math.max(max,helper(piles, k, idx + 1));
        return dp[idx][k] = max;
    }
}
