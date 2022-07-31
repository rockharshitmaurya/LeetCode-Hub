class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int arr_1[]=new int[n]; Arrays.fill(arr_1,-1);
        int arr_2[]=new int[n]; Arrays.fill(arr_2,-1);
        dfs(edges,node1,0,arr_1,new boolean[n]);
        dfs(edges,node2,0,arr_2,new boolean[n]);
        int idx=-1,temp=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(arr_1[i]!=-1 && arr_2[i]!=-1){
                if(Math.max(arr_1[i],arr_2[i])<temp){
                    temp=Math.max(arr_1[i],arr_2[i]);
                    idx=i;
                }
            }
        }
        return idx;
    }
    void dfs(int edges[],int root,int len,int dis[],boolean vis[]){
        if(root==-1 || vis[root]) return;
        vis[root]=true;
        dis[root]=len;
        dfs(edges,edges[root],len+1,dis,vis);
    }
}