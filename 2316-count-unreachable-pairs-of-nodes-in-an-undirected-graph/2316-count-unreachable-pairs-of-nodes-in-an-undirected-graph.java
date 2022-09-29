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
    public long countPairs(int n, int[][] edges) {
        
        parent=new int[n];
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
        }
        for(int arr[]:edges){
            union(arr[0],arr[1]);
        }
        
        long root[]=new long[n];
        
        for(int i=0; i<n; i++){
            root[find(i)]++;
        }
        
        long ans=0;
        int len=n;
        for(int i=0; i<len; i++){ if(root[i]==0) continue;
            long temp=(root[i]*(n-root[i]));
            ans+=temp;
            n-=root[i];
        }
        // System.out.println(Arrays.toString(root));
        return ans;
    }
}