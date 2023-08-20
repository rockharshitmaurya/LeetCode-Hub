class Solution {

    public boolean canMakeSubsequence(String str1, String str2) {
        if (str2.length() > str2.length()) return false;
        
        return helper(str1,str2,0,0);
    }

    boolean helper(String str1, String str2, int idx1, int idx2) {
        if (str1.length() == idx1) return idx2 == str2.length();
        if (str2.length() == idx2) return true;

        if (str1.charAt(idx1) == str2.charAt(idx2)) return helper(str1, str2, idx1 + 1, idx2 + 1);

        if (next(str1.charAt(idx1)) == str2.charAt(idx2)) return helper(str1, str2, idx1 + 1, idx2 + 1);

        return helper(str1, str2, idx1 + 1, idx2);
    }

    char next(char ch) {
        if (ch == 'z') return 'a'; else return ++ch;
    }
}
