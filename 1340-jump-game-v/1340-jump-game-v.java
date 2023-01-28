class Solution {
    int dp[] = new int[1001];

    public int maxJumps(int[] arr, int d) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, dfs(arr, i, d));
        }
        return max;
    }

    int dfs(int arr[], int idx, int d) {
        if (dp[idx] != 0) return dp[idx];
        int res = 1, n = arr.length;

        for (int i = idx + 1; i <= Math.min(n - 1, idx + d) && arr[idx] > arr[i]; i++) {
            res = Math.max(res, 1 + dfs(arr, i, d));
        }
        for (int i = idx - 1; i >= Math.max(0, idx - d) && arr[idx] > arr[i]; i--) {
            res = Math.max(res, 1 + dfs(arr, i, d));
        }
        return dp[idx] = res;
    }
}
