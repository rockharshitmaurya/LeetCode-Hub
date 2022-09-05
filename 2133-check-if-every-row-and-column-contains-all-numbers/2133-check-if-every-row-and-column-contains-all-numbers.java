class Solution {
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        boolean row[]=new boolean[n];
        boolean col[]=new boolean[n];
        for(int i=0; i<n; i++){
                row=new boolean[n];
                col=new boolean[n];
            for(int j=0; j<n; j++){
                
                if(matrix[i][j]>n) return false;
                
                row[matrix[i][j]-1]=true;
                col[matrix[j][i]-1]=true;
                

                
            }
            if(!(check(row) && check(col))) return false;
        }
        
        return true;
    }
    
    boolean check(boolean arr[]){
        for(boolean b:arr){
            if(!b) return false;
        }
        return true;
    }
}