class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        
        
        int ind[]=new int[n];
        
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        
        while(q.size()>0){
            int node=q.poll();
            ind[node]++;
            
            for(int child:rooms.get(node)){
                if(ind[child]==0) q.offer(child);
            }
        }
        
        for(int node:ind) if(node==0) return false;
        return true;
    }
}