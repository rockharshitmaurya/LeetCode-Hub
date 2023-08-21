class Solution {

    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i * 2 < s.length(); i++) {
            sb.append(s.charAt(i));
            if(check(s,sb+"")) return true;
        }
        return 1==2;
    }

    boolean check(String str, String ptr) {
        if (str.length() % ptr.length() != 0 || str.length() == ptr.length()) return false;

        int n = ptr.length();
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            idx = idx % n;
            // System.out.println(i);
            if (str.charAt(i) != ptr.charAt(idx++)) return false;
        }

        return true;
    }
}
