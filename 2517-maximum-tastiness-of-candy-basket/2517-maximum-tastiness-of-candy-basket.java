class Solution {

    public int maximumTastiness(int[] price, int k) {
        int low = 0, high = (int) 1e9;
        Arrays.sort(price);
        int ans = 0;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (ok(price, k - 1, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return ans;
    }

    boolean ok(int arr[], int k, int val) {
        int start = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - start >= val) {
                start = arr[i];
                k--;
            }
        }

        return k <= 0;
    }
}
