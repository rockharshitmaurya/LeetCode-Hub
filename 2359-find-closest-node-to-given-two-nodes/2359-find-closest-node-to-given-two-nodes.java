class Solution {

    public int closestMeetingNode(int[] edges, int n1, int n2) {
        int n = edges.length;
        int a1[] = new int[n];
        int a2[] = new int[n];
        Arrays.fill(a1, -1);
        Arrays.fill(a2, -1);
        dfs(edges, a1, n1, 0);
        dfs(edges, a2, n2, 0);
        int idx = -1, temp = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a1[i] != -1 && a2[i] != -1) {
                if (Math.max(a1[i], a2[i]) < temp) {
                    temp = Math.max(a1[i], a2[i]);
                    idx = i;
                }
            }
        }

        return idx;
    }

    void dfs(int edges[], int dis[], int root, int len) {
        while (root != -1 && dis[root] == -1) {
            dis[root] = len++;
            root = edges[root];
        }
    }
}
