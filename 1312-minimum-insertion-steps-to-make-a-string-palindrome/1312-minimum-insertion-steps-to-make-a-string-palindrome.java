class Solution {
    int dp[][];

    public int minInsertions(String s) {
        String text2 = new StringBuilder(s).reverse().toString();
        dp = new int[s.length()][s.length()];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        return s.length() - helper(s, text2, 0, 0);
    }

    int helper(String str1, String str2, int l, int r) {
        if (l == str1.length() || r == str2.length()) return 0;

        if(dp[l][r]!=-1) return dp[l][r];
        if (str1.charAt(l) == str2.charAt(r)) return 1 + helper(str1, str2, l + 1, r + 1);

        int left = helper(str1, str2, l + 1, r);
        int right = helper(str1, str2, l, r + 1);

        return dp[l][r]=Math.max(left, right);
    }
}
// zzazz
// zzazz
