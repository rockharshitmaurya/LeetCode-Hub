class Solution {
    int parent[];

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b) return true;
        parent[a] = b;
        return false;
    }

    public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int ind[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (left[i] != -1) {
                int a = find(i);
                int b = find(left[i]);
                ind[left[i]]++;
                if (union(i, left[i])) return false;
            }
            if (right[i] != -1) {
                int a = find(i);
                int b = find(right[i]);
                ind[right[i]]++;
                if (union(i, right[i])) return false;
            }
        }
        int count = 0, root = -1;

        for (int i = 0; i < n; i++) {
            if (ind[i] == 0) {
                count++;
                root = i;
            }
        }

        if (count != 1) return false;
        return true;
    }
}
