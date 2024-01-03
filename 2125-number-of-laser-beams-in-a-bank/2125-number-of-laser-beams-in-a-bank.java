class Solution {

    public int numberOfBeams(String[] bank) {
        int prev = 0, cur = 0, ans = 0;
        for (String str : bank) {
            for (char ch : str.toCharArray()) {
                if (ch == '1') cur++;
            }
            if (cur == 0) continue;
            ans += (cur * prev);
            prev = cur;
            cur = 0;
        }
        return ans;
    }
}
