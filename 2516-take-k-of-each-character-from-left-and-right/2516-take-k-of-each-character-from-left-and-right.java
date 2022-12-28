class Solution {

    public int takeCharacters(String s, int k) {
        int count[] = new int[3], ans = Integer.MAX_VALUE, i, n = s.length();
        for (i = 0; i < n; i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
            if (ok(count, k)) {
                ans = Math.min(ans, getSum(count));
                break;
            }
        }

        if (!ok(count, k)) return -1;

        for (int j = n - 1; j >= 0 && i >= 0; j--) {
            while (i > -1 && ok(count, k)) { //reduce window
                char ch2 = s.charAt(i--);
                count[ch2 - 'a']--;

                if (ok(count, k)) {
                    ans = Math.min(ans, getSum(count));
                }
            }

            char ch1 = s.charAt(j); //expend window size
            count[ch1 - 'a']++;
        }
        return ans;
    }

    boolean ok(int arr[], int k) {
        return arr[0] >= k && arr[1] >= k && arr[2] >= k;
    }

    int getSum(int arr[]) {
        return arr[0] + arr[1] + arr[2];
    }
}
