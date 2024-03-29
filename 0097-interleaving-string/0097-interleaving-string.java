class Solution {
    Integer dp[][] = new Integer[101][101];

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        return helper(s1, s2, s3);
    }

    boolean helper(String str1, String str2, String str3, int idx1, int idx2) {
        int idx3 = idx1 + idx2;
        if (idx3 == str3.length()) return true;

        if (dp[idx1][idx2] != null) return dp[idx1][idx2] == 1;
        if (idx1 < str1.length()) {
            if (str1.charAt(idx1) == str3.charAt(idx3)) {
                if (helper(str1, str2, str3, idx1 + 1, idx2)) return true;
            }
        }

        if (idx2 < str2.length()) {
            if (str2.charAt(idx2) == str3.charAt(idx3)) {
                if (helper(str1, str2, str3, idx1, idx2 + 1)) return true;
            }
        }
        dp[idx1][idx2] = 0;
        return false;
    }
    
    boolean helper(String str1, String str2, String str3) {
    int n = str1.length();
    int m = str2.length();
    boolean[][] dp = new boolean[n + 1][m + 1];
    dp[0][0] = true;
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            int p = i + j - 1;
            if (i > 0) {
                dp[i][j] |= (dp[i - 1][j] && str1.charAt(i - 1) == str3.charAt(p));
            }
            if (j > 0) {
                dp[i][j] |= (dp[i][j - 1] && str2.charAt(j - 1) == str3.charAt(p));
            }
        }
    }
    return dp[n][m];
}

}
