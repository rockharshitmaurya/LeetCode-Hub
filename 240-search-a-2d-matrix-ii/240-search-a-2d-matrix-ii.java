class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int row=matrix.length,col=matrix[0].length-1,i=0; 
        while(col>=0 && i<row){
            if(matrix[i][col]==target){
                return true;
            }else if(matrix[i][col]>target){
                col--;
            }else{
                i++;
            }
        }
        return false;
    }
}