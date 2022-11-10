class Solution {
    int parent[];

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        parent[a] = b;
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
                if (a == b) return false;
                union(i, left[i]);
            }
            if (right[i] != -1) {
                int a = find(i);
                int b = find(right[i]);
                ind[right[i]]++;
                if (a == b) return false;
                union(i, right[i]);
            }
        }
        int count=0,root=-1;
        for(int i=0; i<n; i++){
            if(ind[i]==0){
                count++;
                root=i;
            }
        }
        
        if(count!=1) return false;
        return true;
    }
}
