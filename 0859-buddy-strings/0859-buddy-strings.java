class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length())  return false;
    int a = -1, b = -1, diff = 0;
    int[] count = new int[26];
    // check if able to switch with the same character.
    boolean canSwitch = false;
    for (int i = 0; i < A.length(); i++) {
      if (++count[A.charAt(i) - 'a'] >= 2)  canSwitch = true;
      if (A.charAt(i) != B.charAt(i)) {
        diff++;
        if (a == -1)  a = i;
        else if (b == -1)  b = i;
      }
    }
    return (diff == 0 && canSwitch) || (diff == 2 && A.charAt(a) == B.charAt(b) && A.charAt(b) == B.charAt(a));
    }
}