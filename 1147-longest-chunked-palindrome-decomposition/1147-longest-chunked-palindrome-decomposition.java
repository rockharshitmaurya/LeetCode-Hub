class Solution {
    int dp[];

    public int longestDecomposition(String text) {
        dp = new int[text.length()];
        Arrays.fill(dp, -1);
        return (helper(text, 0)) / 2;
    }

    int helper(String text, int idx) {
        int n = text.length();
        if (idx == n) return 0;
        if (dp[idx] != -1) {
            // System.out.println("HI");
            return dp[idx];
        }
        StringBuilder str1 = new StringBuilder(), str2 = new StringBuilder();
        int max = 0;
        for (int i = idx; i < n; i++) {
            str1.append(text.charAt(i));
            str2.insert(0, text.charAt(n - i - 1));
            // str2 = text.charAt(n - i - 1) + str2;
            if (str1.toString().equals(str2.toString())) {
                int temp = 0;
                if (i == n - i - 1) temp = 1;
                temp = 2 + helper(text, i + 1);
                max = Math.max(max, temp);
            }
        }
        return dp[idx] = max;
    }
}
// "ghiabcdefhelloadamhelloabcdefghi"
// "ihgfedcbaollehmadaollehfedcbaihg"
