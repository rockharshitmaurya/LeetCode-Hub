class Solution {

    public int[] colorTheArray(int n, int[][] queries) {
        int ans[] = new int[queries.length];
        int sum = 0;
        int arr[] = new int[n];

        int i = 0;
        for (int sub[] : queries) {
            int idx = sub[0], col = sub[1];
            if (arr[idx] == col) {
                ans[i++] = sum;
                continue;
            }

            if (idx + 1 < n) {
                if (arr[idx] == arr[idx + 1] && arr[idx] != 0) sum -= 1;
                if (col == arr[idx + 1]) sum += 1;
            }

            if (idx - 1 >= 0) {
                if (arr[idx] == arr[idx - 1] && arr[idx] != 0) sum -= 1;
                if (col == arr[idx - 1]) sum += 1;
            }

            ans[i++] = sum;
            arr[idx] = col;
        }

        return ans;
    }
}
