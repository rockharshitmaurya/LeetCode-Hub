class Solution {
    private int[][][][][][] dp;
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        dp = new int[10][2][2][10][10][k+1];
        reset(high+1);
        int max=helper(high + "", 0, 1, 1, 0, 0, 0, k);
        System.gc();
        reset(low+1);
        int min=helper((low - 1) + "", 0, 1, 1, 0, 0, 0, k);
        
        return max-min;
    }

    int helper(String num, int idx, int tight, int isZero, int even, int odd, int str, int k) {
        if (idx == num.length()) {
            if (isZero == 0 && even == odd) {
                return str % k == 0 ? 1 : 0;
            } else {
                return 0;
            }
        }
        if (dp[idx][tight][isZero][even][odd][str % k] != -1)
            return dp[idx][tight][isZero][even][odd][str % k];
        
        int end = (tight == 1) ? num.charAt(idx) - '0' : 9;
        int ans = 0;
        for (int dig = 0; dig <= end; dig++) {
            int newZero = (isZero == 1 && dig == 0) ? 1 : 0;
            int newTight = (tight == 1 && dig == end) ? 1 : 0;

            int new_odd = odd;
            int new_even = even;

            if (newZero == 0) {
                if (dig % 2 == 0) new_even++; else new_odd++;
            }
            int new_number = (str * 10) + dig;
            ans += helper(num, idx + 1, newTight, newZero, new_even, new_odd, new_number, k);
        }
        return dp[idx][tight][isZero][even][odd][str % k] = ans;
    }
    
    void reset(int high){
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 2; j++)
                for (int l = 0; l < 2; l++)
                    for (int m = 0; m < 10; m++)
                        for (int n = 0; n < 10; n++)
                                Arrays.fill(dp[i][j][l][m][n], -1);
    }
}
