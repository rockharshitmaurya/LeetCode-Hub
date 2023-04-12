class Solution {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        ArrayList<Integer> col=topoSort(rowConditions,k);
        ArrayList<Integer> row=topoSort(colConditions,k);
        if(row.size()==0 || col.size()==0) return new int[0][0];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1; i<row.size(); i++){
            map.put(row.get(i),i-1);
        }
        int ans[][]=new int[k][k];
        
        for(int i=0; i<col.size()-1; i++){
            // System.out.println(i);
            ans[i][map.get(col.get(i+1))]=col.get(i+1);
        }
        System.out.println(row);
        System.out.println(col);
        
        
        return ans;
    }

    ArrayList<Integer> topoSort(int matrix[][], int k) {
        k++;
        int topo[] = new int[k];
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<k; i++){
            adj.add(new ArrayList<>());
        }
        for (int arr[] : matrix) {
            adj.get(arr[0]).add(arr[1]);
            topo[arr[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i <k; i++) {
            if (topo[i] == 0) q.offer(i);
        }
        int idx = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node); idx++;
            for(int child:adj.get(node)){
                if(--topo[child]==0) {
                    q.offer(child);
                }
            }  
        }
        
        return idx==k?ans:new ArrayList<>();
    }
}
// [[0,3,0],
//  [0,0,2],
//  [1,0,0]]

// [[3,0,0],
//  [0,0,1],
//  [0,2,0]]
// []