class Solution {

    public int minFlips(int a, int b, int c) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            if (isSet(c, i)) {
                if (isSet(a, i) || isSet(b, i)) {
                    continue;
                } else {
                    ans++;
                    continue;
                }
            }

            if (!isSet(c, i)) {
                if (isSet(a, i) && isSet(b, i)) {
                    ans+=2;
                    continue;
                } else if(isSet(a, i) || isSet(b, i)){
                    ans++;
                    continue;
                }
            }
        }

        return ans;
    }

    boolean isSet(int num, int shift) {
        return ((1 << shift) & num) >= 1;
    }
}
