class Solution {
    int inf = (int) 1e9 + 7;

    public int minTaps(int n, int[] ranges) {
        int arr[][] = new int[n + 1][2];

        for (int i = 0; i < n + 1; i++) {
            if (ranges[i] != 0) {
                arr[i][0] = Math.max(0, i - ranges[i]);
                arr[i][1] = Math.min(n, i + ranges[i]);
            } else {
                arr[i][0] = inf;
                arr[i][1] = inf;
            }
        }

        Arrays.sort(
            arr,
            (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        );

        // System.out.println(Arrays.deepToString(arr));

        int max = 0, next_max = 0;
        int count = 1;
        for (int i = 0; i < n + 1; i++) {
            if (arr[i][0] == inf) break;

            if (arr[i][0] <= max) {
                next_max = Math.max(next_max, arr[i][1]);
            } else {
                if (arr[i][0] <= next_max) {
                    max = next_max;
                    next_max = arr[i][1];
                    count++;
                } else {
                    break;
                }
            }
            // System.out.println(max + "-->" + next_max + " idx: " + i);
        }

        if (max < n) {
            if (next_max >= n) {
                return count;
            }

            return -1;
        }

        return count - 1;
    }
}
