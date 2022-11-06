class Solution {
    ArrayList<Integer> list;
    Long dp[][];

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Arrays.sort(factory, (o1, o2) -> (o1[0] - o2[0]));
        Collections.sort(robot);
        list = new ArrayList<>();

        for (int arr[] : factory) {
            for (int i = 0; i < arr[1]; i++) list.add(arr[0]);
        }
        dp = new Long[robot.size() + 1][list.size()];
        return helper(robot, 0, 0);
    }

    long helper(List<Integer> robot, int i, int j) {
        if (robot.size() == i) return 0;
        if (list.size() == j) return (long) 1e15;


        if (dp[i][j] != null) return dp[i][j];

        long take = Math.abs(robot.get(i) - list.get(j)) + helper(robot, i + 1, j + 1);
        long nottake = helper(robot, i, j + 1);
        return dp[i][j] = Math.min(take, nottake);
    }
}
