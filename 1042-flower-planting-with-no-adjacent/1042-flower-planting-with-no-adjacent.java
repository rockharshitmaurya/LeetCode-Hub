class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int ans[] = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int arr[] : paths) {
            int u = arr[0] - 1;
            int v = arr[1] - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        for(int i=0; i<n; i++){
            int col[]=new int[5];
            
            
            for(int child:adj.get(i)){
                col[ans[child]]=1;
            }
            
            for(int c=1; c<=4; c++){
                if(col[c]==0) ans[i]=c;
            }
        }
        return ans;
    }
}
