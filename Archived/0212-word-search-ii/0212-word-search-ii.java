class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=buildTree(words);
        List<String> ans=new ArrayList<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dfs(board,root,i,j,ans);
            }
        }    
       return ans;
    }
    int dirs[][]={{0,1},{1,0},{-1,0},{0,-1}};
    void dfs(char board[][],TrieNode root,int i,int j,List<String> ans){
        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j]=='#' || root.next[board[i][j]-'a']==null) return;
        char ch=board[i][j];
        root=root.next[ch-'a'];
        if(root.word!=null){
            ans.add(root.word);
            root.word=null;
        }
        
        for(int arr[]:dirs){
            board[i][j]='#';
            dfs(board,root,i+arr[0],j+arr[1],ans);
            board[i][j]=ch;
        }
    }
    TrieNode buildTree(String words[]){
        TrieNode root=new TrieNode();
        for(String word:words){
            TrieNode p=root;
            for(char ch:word.toCharArray()){
                if(p.next[ch-'a']==null) p.next[ch-'a']=new TrieNode();
                p=p.next[ch-'a'];
            }
            p.word=word;
        }
        
        return root;
    }
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
