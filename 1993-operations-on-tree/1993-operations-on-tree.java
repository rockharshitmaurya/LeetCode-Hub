class LockingTree {
    int map[], n;
    ArrayList<ArrayList<Integer>> adj;
    int p_copy[];

    public LockingTree(int[] parent) {
        n = parent.length;
        map = new int[n];
        Arrays.fill(map, -1);
        adj = new ArrayList<>();
        buildGraph(parent);
        p_copy = parent;
    }

    public boolean lock(int num, int user) {
        if (map[num] != -1) return false;
        map[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (map[num] == user) {
            map[num] = -1;
            return true;
        } else return false;
    }

    public boolean upgrade(int num, int user) {
        if (!checkLockedAncestors(p_copy, num)) return false;

        if (unlockDescendant(num) == 0) return false;

        map[num] = user;
        return true;
    }

    void buildGraph(int[] parent) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < parent.length; i++) {
            adj.get(parent[i]).add(i);
        }
    }

    boolean checkLockedAncestors(int parent[], int node) {
        while (parent[node] != -1) {
            if (map[node] != -1) return false;
            node = parent[node];
        }
        return map[node]==-1;
    }

    int unlockDescendant(int node) {
        int res = 0;
        for (int child : adj.get(node)) {
            res += ((map[child] == -1 ? 0 : 1) + unlockDescendant(child));
            map[child] = -1;
        }
        return res;
    }
}
/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
