class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for(int j=0; j<mat[0].length; j++){
            setElement(mat,0,j,getElement(mat,0,j));
        }
        
        for(int j=0; j<mat.length; j++){
            setElement(mat,j,0,getElement(mat,j,0));
        }
        
        return mat;
    }
    
    public ArrayList<Integer> getElement(int[][] mat,int i,int j){
         ArrayList<Integer> dig=new  ArrayList<Integer>();
        while(i<mat.length && j<mat[0].length){
            dig.add(mat[i][j]); i++; j++;
        }
        
        
        
        Collections.sort(dig);
        return dig;
    }
    
    public void setElement(int[][] mat,int i,int j,ArrayList<Integer> dig){
         int index=0;
        while(i<mat.length && j<mat[0].length){
            mat[i][j]=dig.get(index);
            i++; j++; index++;
        }
    }
}
// [3,9]
// [2,4]
// [1,2]
// [9,8]
// [7,3]

// [3,9],
// [2,4],
// [1,2],
// [3,8],
// [7,9]
