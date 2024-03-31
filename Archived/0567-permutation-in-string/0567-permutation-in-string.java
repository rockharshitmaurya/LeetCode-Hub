class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int count[] = new int[26], hash[] = new int[26];
        for (char ch : s1.toCharArray()) {
            count[ch - 'a']++;
        }
        int n1 = s1.length(), n2 = s2.length();

        int r = 0, l = 0;

        while (r < n2) {
            char ch = s2.charAt(r);
            hash[ch - 'a']++;
                while (l <= r && count[ch - 'a'] == 0 || hash[ch - 'a'] > count[ch - 'a']) {
                    //checking either the current char is not present in str1 or frequency of the current char is greater than str1
                    char ch2 = s2.charAt(l);
                    hash[ch2 - 'a']--;
                    l++;
                }
            if ((r - l + 1) == n1) return true;
            r++;
        }
        return false;
    }
}
