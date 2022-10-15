class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        // dp[i][k]: the minimum length for s[:i] with at most k deletion.
        int n = s.length();
        int[][] dp = new int[110][110];
        for (int i = 0; i <= n; i++) for (int j = 0; j <= n; j++) dp[i][j] = 9999;
		// for (int[] i : dp) Arrays.fill(i, n); // this is a bit slower (100ms)
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {                
                int cnt = 0, del = 0;
                for(int l = i; l >= 1; l--) { // keep s[i], concat the same, remove the different
                    if(s.charAt(l - 1) == s.charAt(i - 1)) cnt++;
                    else del++;
                    if(j - del >= 0) 
                        dp[i][j] = Math.min(dp[i][j], 
                                            dp[l-1][j-del] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1: 0));
                }
                if (j > 0) // delete s[i]
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
            }
        }
        return dp[n][k];
    }
}


// class Solution {

//     public int getLengthOfOptimalCompression(String s, int k) {
//         return helper(s.toCharArray(), k, 0, '#', 0, 0);
//     }

//     int helper(char str[], int k, int idx, char last, int count, int len) {
//         if (idx == str.length) {
//             if(k>=0) return len;
//             else return str.length;
//         }

//         int a = str.length, b = a, c = a;
//         if (str[idx] != last) {
//             a = helper(str, k - 1, idx + 1, last, count + 1, len+getLen(count)+1);
//             b = helper(str, k, idx + 1, str[idx], 1, len);
//         } else {
//             c = helper(str, k, idx + 1, str[idx], count + 1, len);
//         }

//         return Math.min(a, Math.min(b, c));
//     }

//     int getLen(int x) {
//         return x == 1 ? 0 : x < 10 ? 1 : x < 100 ? 2 : 3;
//     }
// }
