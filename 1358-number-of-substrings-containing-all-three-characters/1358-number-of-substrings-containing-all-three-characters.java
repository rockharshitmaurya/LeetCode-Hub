class Solution {

    public int numberOfSubstrings(String s) {
        int ans = 0, i = 0, arr[] = new int[3];

        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;

            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                arr[s.charAt(i++) - 'a']--;
            }
            ans += i;
            // For people who can't understand res+=i
            // res += i
            // This is the best line ever

            // a a a b b c c a b c
            // when all a, b, c > 0 for first time at j = 5 the n after while loop i will be at i = 3, we will add 3 to result because there would be three substrings from three a's.

            // Then a,b,c > 0 at j = 7 ,then we will move i until i = 5 then we will add 5 to result because there could be 5 substrings starting from 0 to second b.

            // And similarly we proceed....
        }
        return ans;
    }
}
