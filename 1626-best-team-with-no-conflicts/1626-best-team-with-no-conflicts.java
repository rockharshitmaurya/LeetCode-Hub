class Solution {
    int dp[][];

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int pair[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i] = new int[] { scores[i], ages[i] };
        }
        Arrays.sort(
            pair,
            (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        );
        dp = new int[n][n+1];
        for (int arr[] : dp) Arrays.fill(arr, -1);
        return helper(pair, 0, -1);
    }

    int helper(int arr[][], int idx, int last) {
        if (idx == arr.length) return 0;

        if (last != -1 && arr[last][0] > arr[idx][0]) return helper(arr, idx + 1, last);
        
        if (dp[idx][last+1] != -1) return dp[idx][last+1];
        
        int next = (last == -1 || arr[last][0] <= arr[idx][0]) ? idx : last;
        
        int choose = arr[idx][0] + helper(arr, idx + 1, next);
        int notchoose = helper(arr, idx + 1, last);
        
        // if (last != -1) {
        //     dp[idx][last+1] = Math.max(choose, notchoose);
        //     return dp[idx][last+1];
        // }
        return dp[idx][last+1] = Math.max(choose, notchoose);
    }
}
