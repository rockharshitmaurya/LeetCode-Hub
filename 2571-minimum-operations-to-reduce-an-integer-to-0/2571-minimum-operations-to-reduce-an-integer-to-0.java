class Solution {
public static int minOperations(int n) {
    int cnt = 0, a, b;
    while (n>0) {
        cnt++;
        a = (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)));
        b = (int) Math.pow(2, Math.floor(Math.log(n) / Math.log(2)));
        if (a - n < n - b) {
            n = a-n;
        } else {
            n = n-b;
        }
    }
    return cnt;
}
}