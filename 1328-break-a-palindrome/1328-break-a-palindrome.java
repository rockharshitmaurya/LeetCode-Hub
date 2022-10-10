class Solution {

    // https://leetcode.com/problemset/all/

    public String breakPalindrome(String pl) {
        if (pl.length()==1) return "";
        char rep = 'a';
        char arr[] = pl.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (n % 2 == 1 && i == (n / 2)) continue;
            if (arr[i] > rep) {
                arr[i] = rep;
                break;
            }
        }

        String ans = new String(arr);
        if (ans.equals(pl)){
            arr[n-1]++;
            ans = new String(arr);
        } 

        return ans;
    }
}
// aabaa
