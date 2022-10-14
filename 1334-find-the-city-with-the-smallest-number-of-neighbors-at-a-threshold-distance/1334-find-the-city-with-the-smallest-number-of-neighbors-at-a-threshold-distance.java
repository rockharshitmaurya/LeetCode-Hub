class Solution {
    public int findTheCity(int n, int[][] edges, int dt) {
        int matrix[][]=new int[n][n];
        for(int arr[]:matrix) Arrays.fill(arr,100000);
        for(int i=0; i<n; i++) matrix[i][i]=0;
        
        for(int arr[]:edges){
            matrix[arr[0]][arr[1]]=matrix[arr[1]][arr[0]]=arr[2];
        }
        
        for(int vie=0; vie<n; vie++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][vie]+matrix[vie][j]);
                }
            }
        }
        int reach=n,ans=0;
        for(int i=0; i<n; i++){
            int count=0;
            for(int j=0; j<n; j++){
                if(matrix[i][j]<=dt){
                    count++;
                }
            }
            if(count<=reach){
                reach=count;
                ans=i;
            }
        }
        return ans;
    }
}