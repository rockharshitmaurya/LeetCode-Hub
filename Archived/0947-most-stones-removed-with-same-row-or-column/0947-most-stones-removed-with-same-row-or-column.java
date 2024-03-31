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
        for(int arr[]:grid){ // we are unioning row and cols not node , so anything comes in same row and cols will be merged autometicalls
             union(arr[0],arr[1]+m); //two uniqly identify row and cols we have added m in cols so that we can distenguish between them
        }
        
        for(int arr[]:grid){
                int x=find(arr[0]);
                size[x]++;
        }
        int ans=0;
        // System.out.println(Arrays.toString(parent));
        for(int i=0; i<size.length; i++){
            if(size[i]>0) ans++;
        }
       return grid.length-ans;
    }
}