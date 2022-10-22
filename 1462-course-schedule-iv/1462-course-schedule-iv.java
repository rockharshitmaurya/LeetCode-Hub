class Solution {
    
    public List<Boolean> checkIfPrerequisite(int n, int[][] pr, int[][] q) {
        int dis[][]=new int[n][n];
        List<Boolean> list=new ArrayList<>();
        
        int INF=(int)1e9;
        for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i==j) dis[i][j]=0;
                    else{
                        dis[i][j]=INF;
                    }
                }
        }
        for(int arr[]:pr) dis[arr[0]][arr[1]]=1; 
        
        for(int vie=0; vie<n; vie++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                        dis[i][j]=Math.min(dis[i][vie]+dis[vie][j],dis[i][j]);
                }
            }
        }
        
        for(int arr[]:q){
            if(dis[arr[0]][arr[1]]==INF) list.add(false);
            else list.add(true);
        }
        return list;
    }
}