class Solution {
    int parent[]=new int[26];
    void union(int u,int v){
        int a=find(u);
        int b=find(v);
        parent[a]=b;
    }
    
    int find(int x){
        if(parent[x]==x) return x;
        
        return parent[x]=find(parent[x]);
    }
    public boolean equationsPossible(String[] equations) {
        for(int i=0; i<26; i++){
            parent[i]=i;
        }
        for(String str:equations){
            if(str.charAt(1)=='=' && str.charAt(2)=='=') 
                union(str.charAt(0)-'a',str.charAt(3)-'a');
        }
        
        for(String str:equations){
            if(str.charAt(1)=='=' && str.charAt(2)=='=') 
            {
                
            }
            else{
                if(find(str.charAt(0)-'a')==find(str.charAt(3)-'a')){
                    return false;
                }
            }
        }
       return true; 
    }
}