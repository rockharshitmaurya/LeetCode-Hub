class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int arr[][]=new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[j][i]=matrix[i][j];
            }
        }
        
        for(int sub[]:arr){
           for(int i=0; i*2<n; i++){
               int temp=sub[i];
               sub[i]=sub[n-i-1];
               sub[n-i-1]=temp;
           } 
        }
        
        // System.out.println(Arrays.deepToString(arr));
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j]=arr[i][j];
            }
        }
    }
}