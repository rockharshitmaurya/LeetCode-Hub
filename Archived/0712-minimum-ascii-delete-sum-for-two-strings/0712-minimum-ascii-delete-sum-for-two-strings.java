class Solution {
    int dp[][];

    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[1001][1001];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        int sum = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum += s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            sum += s2.charAt(i);
        }

        int ans = helper(s1, s2, 0, 0);
        // System.out.println(ans);
        ans *= 2;

        return sum - ans;
    }

    int helper(String str1, String str2, int idx1, int idx2) {
        if (idx1 == str1.length() || idx2 == str2.length()) {
            return 0;
        }
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if (str1.charAt(idx1) == str2.charAt(idx2)) {
            return str1.charAt(idx1) + helper(str1, str2, idx1 + 1, idx2 + 1);
        }

        int left = helper(str1, str2, idx1 + 1, idx2);
        int right = helper(str1, str2, idx1, idx2 + 1);

        return dp[idx1][idx2]=Math.max(left, right);
    }
}
