class Solution {

    public int[][] insert(int[][] input, int[] j) {
        int start = -1, end = -1;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i][1] < j[0] || input[i][0] > j[1]) {
                list.add(new int[] { input[i][0], input[i][1] });
            }
            if (j[0] >= input[i][0] && j[0] <= input[i][1]) {
                start = Math.min(j[0], input[i][0]);
            }
            if (j[1] >= input[i][0] && j[1] <= input[i][1]) {
                end = Math.max(j[1], input[i][1]);
            }
        }
        list.add(new int[] { start == -1 ? j[0] : start, end == -1 ? j[1] : end });
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) dp[i] = list.get(i);

        return dp;
    }
}
