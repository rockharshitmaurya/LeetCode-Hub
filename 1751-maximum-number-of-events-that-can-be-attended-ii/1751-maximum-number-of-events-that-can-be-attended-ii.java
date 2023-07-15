class Solution {
    HashMap<String, Integer> dp;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(
            events,
            (o1, o2) -> {
                if (o1[0] != o2[0]) return o1[0] - o2[0]; else return o1[1] - o2[1];
            }
        );
        int n = events.length;
        dp = new HashMap<>();
        return helper(events, 0, -1, k);
    }

    int helper(int events[][], int idx, int last, int k) {
        if (k == 0 || idx == events.length) return 0;
        String key = idx + ":" + last + ":" + k;
        // if (dp[idx][last + 1][k] != -1) return dp[idx][last + 1][k];
        if(dp.containsKey(key)) return dp.get(key);
        int attend = 0, notattend = 0;
        if (last == -1 || events[idx][0] > events[last][1]) {
            attend = events[idx][2] + helper(events, idx + 1, idx, k - 1);
        }
        notattend = helper(events, idx + 1, last, k);

        // return dp[idx][last + 1][k]
            dp.put(key,Math.max(attend, notattend));
        return Math.max(attend, notattend);
    }
}
