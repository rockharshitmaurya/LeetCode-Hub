class Solution {

    public int maxPalindromes(String s, int k) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int len = (j - i) + 1;
                if (len > k + 1) break;
                if (len >= k && isPalindrome(s, i, j)) {
                    ans++;
                    i = j;
                    break;
                }
            }
        }
        return ans;
    }

    boolean isPalindrome(String s, int l, int r) {
        return l >= r || s.charAt(l) == s.charAt(r) && isPalindrome(s, l + 1, r - 1);
    }
}
