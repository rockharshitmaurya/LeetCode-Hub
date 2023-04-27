class Solution {

    public int minMovesToMakePalindrome(String s) {
        int n = s.length();
        int ans = 0;

        int l = 0, r = n - 1;
        StringBuilder sb = new StringBuilder(s);

        while (l < r) {
            char ch1 = sb.charAt(l);
            char ch2 = sb.charAt(r);

            int first = l;
            int last = r;

            while (last > l && sb.charAt(last) != ch1) {
                last--;
            }

            while (first < r && sb.charAt(first) != ch2) {
                first++;
            }

            int right = (r - last);
            int left = (first - l);
            if (right <= left) {
                sb.deleteCharAt(last);
                sb.append(ch1);
                ans += right;
            }else{
                sb.deleteCharAt(first);
                sb.insert(0,ch2);
                ans += left;
            }

            r--;
            l++;
        }
        System.out.println(sb);
        return ans;
    }
}
// skhaunegmdtutluii
// skwhanegmdtutluu
// 5-2=3
