class Solution {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int parent[], size[];

    public int largestComponentSize(int[] nums) {
        int max = 0;
        for (int num : nums) {
            helper(num);
            max = Math.max(max, num);
        }
        parent = new int[max + 1];
        size = new int[max + 1];

        for (int i = 0; i < size.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (ArrayList<Integer> adj : map.values()) {
            if (adj.size() < 1) continue;

            for (int i = 1; i < adj.size(); i++) {
                union(adj.get(0), adj.get(i));
            }
        }

        // System.out.println(Arrays.toString(size));
        int ans=0;
        for(int num:size){
            ans=Math.max(ans,num);
        }
        return ans;
    }

    private int helper(int x) {
        int x_cpy = x;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                if (!map.containsKey(i)) {
                    map.put(i, new ArrayList<>());
                }
                map.get(i).add(x_cpy);
                while (x % i == 0) {
                    x /= i;
                }
            }
        }

        if (x > 1) {
            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(x_cpy);
        }

        return 0;
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int u = find(x);
        int v = find(y);
        if (u == v) return;
        if (size[u] < size[v]) {
            parent[u] = v;
            size[v] += size[u];
        } else {
            parent[v] = u;
            size[u] += size[v];
        }
    }
}
// 4-> 2,
// 6-> 2, 3,
// 15->3, 5,
// 35->5, 7,
// 20->2 2 5
// 50->2 5 5
// 9-> 3 3
// 63-> 3 3 7
