class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        
            for(int i=0; i<n; i++){
                adj.add(new ArrayList<>());
            }
            
            for(int arr[]:flights){
                adj.get(arr[0]).add(new int[]{arr[1],arr[2]});
            }
        
            Queue<int[]> q=new LinkedList<>();
            
            int dis[]=new int[n];
            
            Arrays.fill(dis,(int)1e9);
            dis[src]=0;
            q.offer(new int[]{src,0,0});
        
        
            while(!q.isEmpty()){
                int node=q.peek()[0];
                int stops=q.peek()[1];
                int cost=q.poll()[2];
                
                if(stops>k) continue;
                
                for(int arr[]:adj.get(node)){
                    if(arr[1]+cost<dis[arr[0]]){
                        dis[arr[0]]=arr[1]+cost;
                        q.offer(new int[]{arr[0],stops+1,dis[arr[0]]});
                    }
                }
            }
        
        
        return dis[dst]==(int)1e9?-1:dis[dst];
    }
}