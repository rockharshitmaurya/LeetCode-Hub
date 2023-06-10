class Solution {

    public int maxValue(int n, int index, int maxSum) {
        long l = 0, r = maxSum, ans = 0;
        while (l <= r) {
            long mid = (l + r) >> 1;
            if (ok(n, index, maxSum, mid)) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }

        return (int) ans;
    }

    boolean ok(int n, int idx, int max, long mid) {
        for (long i = idx, sub = mid; i >= 0; i--, sub--) {
            if (sub < 1) {
                max -= (i + 1);
                break;
            }
            max -= sub;
            if (max < 0) return false;
        }

        for (long i = idx + 1, sub = mid - 1; i < n; i++, sub--) {
            if (sub < 1) {
                max -= (n - i);
                break;
            }
            max -= sub;
            if (max < 0) return false;
        }

        return max >= 0;
    }
}
