class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    // System.out.println(i+" "+j);
                    char ch=board[i][j]; board[i][j]='.';
                    if(!isValid(board,i,j,ch)) return false;
                    board[i][j]=ch;
                }
            }
        }
     return true;   
    }
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            // System.out.println(i+" ");
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}