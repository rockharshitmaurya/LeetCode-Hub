class Solution {
    long ans = 0;
    int s;
    public long minimumFuelCost(int[][] road, int seats) {
        int n = road.length+1; s=seats;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int arr[]:road){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        ok(0,-1,adj);
        return ans;
    }
    
    int ok(int root,int parent,ArrayList<ArrayList<Integer>> adj){
        int people=1;
        for(int node:adj.get(root)) { if(node==parent) continue;
            people+=ok(node,root,adj);
        }
        
        if(root!=0) {            
            ans += (people/s);
            if((people%s)!=0) ans++; //if some people left that means we have to use one more car
        }
        return people;
    }
}