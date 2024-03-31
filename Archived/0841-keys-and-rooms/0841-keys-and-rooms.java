class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        int vis[]=new int[n];
        helper(rooms,vis,0);
        for(int key:vis){
            if(key==0) return false;
        }
        return true;
    }
    
    void helper(List<List<Integer>> rooms,int vis[],int key){
        if(vis[key]!=0) return;
        vis[key]++;
        
        for(int keys:rooms.get(key)){
            helper(rooms,vis,keys);
        }
    }
}
