class Solution {

    public int maxVowels(String s, int k) {
        int ans = 0, count = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            boolean flag = check(s.charAt(r));
            if (r < k) {
                if (flag) count++;
            } else {
                if (flag) count++;
                flag = check(s.charAt(l));
                if (flag) count--;
                l++;
            }
            ans = Math.max(ans, count);
            r++;
        }
        return ans;
    }

    boolean check(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
