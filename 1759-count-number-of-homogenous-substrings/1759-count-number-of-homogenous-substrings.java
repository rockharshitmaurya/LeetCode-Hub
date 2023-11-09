class Solution {
    long MOD = (long) 1e9 + 7;

    public int countHomogenous(String s) {
        int i = 0;
        long ans = 0;
        while (i < s.length()) {
            int idx = i;
            long len = 0L;

            while (i < s.length() && s.charAt(i) == s.charAt(idx)) {
                len++;
                i++;
            }

            ans = (ans + (len * (len + 1)) / 2) % MOD;
        }
        return (int)ans;
    }
}
