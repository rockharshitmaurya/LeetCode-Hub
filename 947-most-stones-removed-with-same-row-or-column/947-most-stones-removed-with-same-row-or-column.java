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
    public int removeStones(int[][] grid) {
        int m=0,n=0;
        for(int arr[]:grid){
             m=Math.max(arr[0],m);
             n=Math.max(arr[1],n);
        } n++; m++;
        parent=new int[n+m];
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
        }
        int size[]=new int[n+m];
        for(int arr[]:grid){
             union(arr[0],arr[1]+m);
        }
        
        for(int arr[]:grid){
                int x=find(arr[0]);
                size[x]++;
        }
        int ans=0;
        // System.out.println(Arrays.toString(size));
        // for(int i=0; i<parent.length; i++){
        //     if(parent[i]==i) ans++;
        // }
        
        for(int i=0; i<size.length; i++){
            if(size[i]>0) ans++;
        }
        // System.out.println(ans);
       return grid.length-ans;
    }
}