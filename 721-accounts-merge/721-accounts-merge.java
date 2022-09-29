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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res=new ArrayList<>();
        int n = accounts.size();
         parent=new int[n];
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
        }
        HashMap<String,Integer> emailToId=new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                 String email = accounts.get(i).get(j);
                 int curID=i;
                 if(emailToId.containsKey(email)){
                     int old=emailToId.get(email);
                     union(old,curID);
                 }else{
                     emailToId.put(email,curID);
                 }
            }
        }
        
        
        Map<Integer, TreeSet> idToEmailMap = new HashMap<>();
        
        for(int i=0; i<n; i++){
            int root=find(i);
            idToEmailMap.putIfAbsent(root,new TreeSet<String>());
            idToEmailMap.get(root).addAll(accounts.get(i).subList(1,accounts.get(i).size()));
        }
        
        
        for(int key:idToEmailMap.keySet()){
            ArrayList<String> toadd=new ArrayList<>(idToEmailMap.get(key));
            toadd.add(0,accounts.get(key).get(0));
            res.add(toadd);
        }
        
        return res;
    }
}