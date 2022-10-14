class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int ind[][]=new int[n][2];
        ArrayList<HashSet<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new HashSet<>());
        }
        // System.out.println(adj);
        for(int arr[]:roads){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
            ind[arr[0]][1]++; ind[arr[0]][0]=arr[0];
            ind[arr[1]][1]++; ind[arr[1]][0]=arr[1];
        }
        int ans=0;
        // Arrays.sort(ind,(o1,o2)->(o2[1]-o1[1]));
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int score=ind[i][1]+ind[j][1];
                
                if(adj.get(ind[i][0]).contains(ind[j][0])) score--;
                
                ans=Math.max(ans,score);
                // return ans;
            }
        }
        return ans;
    }
}