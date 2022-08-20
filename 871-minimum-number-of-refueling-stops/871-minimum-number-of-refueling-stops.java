class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> pq=new PriorityQueue<>();
        int ans=0,i=0,n=stations.length,res;
        for(res=0; startFuel<target; res++){
            
            while(i<n && stations[i][0]<=startFuel)
                pq.add(-stations[i++][1]);
            if(pq.size()==0) return -1;
            startFuel+= -pq.poll();
            
            
        }
        return res;
    }
}