class Solution {
    int MOD = (int) 1e9 + 7;
    int dp[][][][];

    public int countSteppingNumbers(String low, String high) {
        dp = new int[101][11][2][2];
        for (int arr3[][][] : dp) {
            for (int arr2[][] : arr3) {
                for (int arr1[] : arr2) {
                    Arrays.fill(arr1, -1);
                }
            }
        }
        int totle = (helper(high, 1, 0, -1, 1)) % MOD;
        for (int arr3[][][] : dp) {
            for (int arr2[][] : arr3) {
                for (int arr1[] : arr2) {
                    Arrays.fill(arr1, -1);
                }
            }
        }
        int sub = (helper(low, 1, 0, -1, 1)) % MOD;
        int isComman = check(low) == true ? 1 : 0;

        return ((totle - sub + isComman) + MOD) % MOD;
    }

    int helper(String str, int tight, int idx, int last, int isZero) {
        if (str.length() == idx) {
            return last == -1 ? 0 : 1;
        }

        if (dp[idx][last + 1][tight][isZero] != -1) return dp[idx][last + 1][tight][isZero];

        int end = (tight == 1) ? str.charAt(idx) - '0' : 9;

        int sum = 0;
        for (int dig = 0; dig <= end; dig++) {
            int new_limit = (tight == 1 && dig == end) ? 1 : 0;
            int nextZero = (isZero == 1 && dig == 0) ? 1 : 0;

            if (isZero == 1 || Math.abs(last - dig) == 1) {
                sum = (sum + helper(str, new_limit, idx + 1, dig, nextZero)) % MOD;
            }
        }

        return dp[idx][last + 1][tight][isZero] = sum;
    }

    boolean check(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (Math.abs(str.charAt(i) - str.charAt(i - 1)) != 1) return false;
        }
        return true;
    }
}
