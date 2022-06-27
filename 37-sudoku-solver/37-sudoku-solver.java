class Solution {
    public void solveSudoku(char[][] board) {
         helper(board);
    }
    boolean helper(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    for(char ch='1'; ch<='9'; ch++){
                        if(isValid(board,i,j,ch)){
                            board[i][j]=ch;
                            if(helper(board)) return true;
                            else board[i][j]='.';
                        }
                    }
                    return false;
                }
                
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}