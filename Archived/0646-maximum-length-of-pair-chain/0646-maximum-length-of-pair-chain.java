class Solution {

    public int findLongestChain(int[][] pairs) {
        // Arrays.sort(
        //     pairs,
        //     (o1, o2) -> {
        //         return o1[0] - o2[1];
        //     }
        // );
        
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);

        // System.out.println(Arrays.deepToString(pairs));

        int n = pairs.length;
        int dp[] = new int[n];
        int ans = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] += max;
            ans = Math.max(ans, dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return ans;
    }
}
