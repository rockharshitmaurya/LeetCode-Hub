class Solution {
    int dp[];

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = profit.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < startTime.length; i++) {
            list.add(new int[] { startTime[i], endTime[i], profit[i] });
        }

        Collections.sort(list, (o1, o2) -> (o1[0] - o2[0]));

        return helper(list, 0);
    }

    int helper(ArrayList<int[]> list, int idx) {
        if (list.size() == idx) return 0;


        if (dp[idx] != -1) return dp[idx];
        int take = 0, nottake = 0;
        take = list.get(idx)[2] + helper(list,  findNext(list,idx));
        nottake = helper(list, idx + 1);
        return dp[idx] = Math.max(take, nottake);
    }

    public int findNext(ArrayList<int[]> events, int idx) {
        int n = events.size();
        int ans = n;
        int l = idx + 1;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (events.get(idx)[1] <= events.get(mid)[0]) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
