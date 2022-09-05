class Solution {
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        boolean row[]=new boolean[n];
        boolean col[]=new boolean[n];
        for(int i=0; i<n; i++){
                row=new boolean[n];
                col=new boolean[n];
            int c_row=0,c_col=0;
            for(int j=0; j<n; j++){
                if(matrix[i][j]>n) return false;
                
                if(!row[matrix[i][j]-1]){
                    row[matrix[i][j]-1]=true;
                    c_row++;
                }
                if(!col[matrix[j][i]-1]){
                    col[matrix[j][i]-1]=true;
                    c_col++;
                }
            }
            if(c_row!=n || c_col!=n) return false;
        }
        
        return true;
    }
}