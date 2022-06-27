class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][]=new char[n][n];
        List<List<String>> ans=new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }
        helper(0,board,ans);
        return ans;
    }
void helper(int row,char board[][],List<List<String>> ans){
        if(row==board.length){
            ArrayList<String> res=new ArrayList<>();
            for(char ch[]:board){
                res.add(new String(ch));
            }
            ans.add(res);
            return;
        }
        for(int col=0; col<board.length; col++){
            if(board[row][col]=='.' && isQueenSafe(board,row,col)){
                board[row][col]='Q';
                helper(row+1,board,ans);
                board[row][col]='.';
            }
        }
    }
    boolean isQueenSafe(char chess[][],int row,int col){
            for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
                if(chess[i][j] == 'Q'){
                    return false;
                }
            }

            for(int i = row - 1, j = col; i >= 0; i--){
                if(chess[i][j] == 'Q'){
                    return false;
                }
            }

            for(int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++){
                if(chess[i][j] == 'Q'){
                    return false;
                }
            }

            for(int i = row, j = col - 1; j >= 0; j--){
                if(chess[i][j] == 'Q'){
                    return false;
                }
            }

            return true;
    }
}