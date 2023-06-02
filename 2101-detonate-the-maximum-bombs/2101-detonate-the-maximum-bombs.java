class Solution {

    public int maximumDetonation(int[][] bombs) {
        // Arrays.sort(bombs,(o1,o2)->(o2[2]-o1[2]));
        int ans = 0;
        for (int i = 0; i < bombs.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            ans=Math.max(ans,dfs(i, bombs, set));
        }

        return ans+1;
    }

    int dfs(int idx, int bombs[][], HashSet<Integer> set) {
        int row = bombs[idx][0];
        int col = bombs[idx][1];
        int r = bombs[idx][2];
        int ans = 0;

        for (int i = 0; i < bombs.length; i++) {
            int u = bombs[i][0];
            int v = bombs[i][1];
            int r1 = bombs[i][2];
            if (set.contains(i) || isOk(row, col, u, v, r) == false) continue;
            set.add(i);
            ans += (1 + dfs(i, bombs, set));
        }
        return ans;
    }

    public boolean isOk(int i, int j, int k, int l, int R) {
        return (Math.pow(k - i, 2) + Math.pow(l - j, 2)) <= Math.pow(R, 2);
    }
}
