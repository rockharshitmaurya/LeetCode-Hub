class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr2) {
            set.add(num);
        }
        int n = arr1.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], (int) 1e9);
        }
        dp[0][0] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] < arr1[i]) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], arr1[i]);
                }
                Integer high = set.higher(dp[i][j]);
                if (high != null) {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], high);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[n][i] < (int) 1e9) return i;
        }
        return -1;
    }
}
