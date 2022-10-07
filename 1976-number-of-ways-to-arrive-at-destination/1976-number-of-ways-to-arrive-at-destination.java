class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD=(int)1e9+7; 
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int arr[]:roads){
            adj.get(arr[0]).add(new int[]{arr[1],arr[2]});
            adj.get(arr[1]).add(new int[]{arr[0],arr[2]});   
        }
        
        int dis[]=new int[n];
        int ways[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        
        dis[0]=0;
        ways[0]=1;
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->(o1[1]-o2[1]));
        pq.offer(new int[]{0,0});
        
        int max=MOD,ans=-1;
        
        while(!pq.isEmpty()){

            int node=pq.peek()[0];
            int cost=pq.poll()[1];
            // if(cost>dis[node]) continue;
            for(int arr[]:adj.get(node)){
                if(cost+arr[1]<dis[arr[0]]){
                    dis[arr[0]]=(cost+arr[1]);
                    pq.offer(new int[]{arr[0],dis[arr[0]]});
                    ways[arr[0]]=ways[node];
                }else if(cost+arr[1]==dis[arr[0]]){
                    ways[arr[0]]=(ways[arr[0]]+ways[node])%MOD;
                }
            }
        }
        
        return ways[n-1];
    }
}