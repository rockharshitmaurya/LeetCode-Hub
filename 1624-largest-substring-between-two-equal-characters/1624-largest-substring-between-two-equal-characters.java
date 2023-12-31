class Solution {
    //Not done by me
    public int maxLengthBetweenEqualCharacters(String s) {
        int x = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int p = 0;
            for (int j = i + 1; j < s.length(); j++) {
                  // Increment p before checking the condition
                if (s.charAt(j) == ch && x < p) {
                    x = p;
                }
                p++;
            }
        }
        return x;
    }
}