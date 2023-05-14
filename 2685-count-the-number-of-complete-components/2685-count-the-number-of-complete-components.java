class Solution {
    
    int parent[];
    void union(int u,int v){
        int a=find(u);
        int b=find(v);
        parent[a]=b;
    }
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    HashMap<Integer,Integer> map=new HashMap<>();
    
    public int countCompleteComponents(int n, int[][] edges) {
        parent=new int[n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            parent[i]=i;
            adj.add(new ArrayList<>());
        }
        
        for(int arr[]:edges){
            union(arr[0],arr[1]);
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        int ans=0;
        boolean vis[]=new boolean[n];

        for(int i=0; i<n; i++){
            if(parent[i]==i){
                 map=new HashMap<>();
                 vis=new boolean[n];
                 helper(adj,i,vis);
                 if(calc()) ans++;
                 // System.out.println(map);
            }
        }
        
        return ans;
    }
    
    boolean calc(){
        int size=map.size();
         
        for(int val:map.values()){
            if(val!=size-1) return false;
        }
        
        return true;
    }
    
     void helper(ArrayList<ArrayList<Integer>> adj,int root,boolean vis[]){
        if(map.containsKey(root)) return;
         
         vis[root]=true;
         map.put(root,0);
         
         for(int child:adj.get(root)){
             map.put(root,map.get(root)+1);
             helper(adj,child,vis);
         }
    }
}