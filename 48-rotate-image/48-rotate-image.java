class Solution {
    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        int n=matrix.length,m=matrix[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j*2<m; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][m-j-1];
                matrix[i][m-j-1]=temp;
            }
        }
        // return matrix;
    }
    
    void transposeMatrix(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr[i].length; j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }
}