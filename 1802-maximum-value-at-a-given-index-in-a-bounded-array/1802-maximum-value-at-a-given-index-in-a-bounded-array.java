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
        // System.out.println(ok(n, index, maxSum, 3));
        return (int) ans;
    }

    boolean ok(int n, int index, int maxSum, long mid) {
        long sum = 0;
        for (long i = index, val = mid; i >= 0; i--, val--) {
            if (val < 1) {
                sum += (i + 1);
                break;
            }
            sum += val;
            if (sum > maxSum) return false;
        }

        for (long i = index + 1, val = mid - 1; i < n; i++, val--) {
            if (val < 1) {
                sum += (n - i);
                break;
            }
            sum += val;
            if (sum > maxSum) return false;
        }
        return sum <= maxSum;
    }
}
