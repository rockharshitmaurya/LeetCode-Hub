class Solution {
    int parent[], ans;

    public int regionsBySlashes(String[] grid) {
        int n = grid.length; ans=0;
        int dots = n + 1;
        parent = new int[dots * dots];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < dots; i++) {
            for (int j = 0; j < dots; j++) {
                if (i == 0 || j == 0 || i == dots - 1 || j == dots - 1) {
                    int cellno = (i * dots) + j;
                    
                    union(cellno, 0);
                }
            }
        }
        // System.out.println("Started");
        for (int i = 0; i < n; i++) {
        // System.out.println(grid[i].length());
            for (int j = 0; j < n; j++) {

                if (grid[i].charAt(j) == '/') {
                    int cellno1= i*dots + j+1;
                    int cellno2= (i+1) * dots + j;
                    union(cellno1, cellno2);
                } else if (grid[i].charAt(j) == '\\') {
                    int cellno1= i*dots + j;
                    int cellno2= (i+1) * dots + (j+1);
                    union(cellno1, cellno2);
                }
            }
        }

        return ans;
    }

    void union(int u,int v){
        int a=find(u);
        int b=find(v);
        
        if(a==b) ans++;
        parent[a]=b;
    }
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
}
