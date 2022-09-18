class Solution {
    class Node{
    Node links[];
    boolean flag;
    int count;
    public Node(){
        links=new Node[26];
        flag=false;
        count=0;
    }
    boolean containsKey(char c){
        return links[c-'a']!=null;
    }
    Node get(char c){
        return links[c-'a'];
    }
    void put(char c,Node toadd){
        links[c-'a']=toadd;
    }
    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
       
}
class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node=root;
        for(char c:word.toCharArray()){
            if(!node.containsKey(c)){
                node.put(c,new Node());
            }
            node=node.get(c); 
            node.count++;
        }
        node.setEnd();
        
    }
    
    public boolean search(String word) {
        Node node=root;
        for(char c:word.toCharArray()){
            if(!node.containsKey(c)) return false;
            
            node=node.get(c);
        }
        return node.isEnd();
    }
    
    public int startsWith(String prefix) {

        Node node=root;
        int ans=node.count;
        for(char c:prefix.toCharArray()){
            node=node.get(c);
            ans+=node.count;
        }
        return ans;
    }
}
    public int[] sumPrefixScores(String[] words) {
        Trie root=new Trie();
        int n=words.length;
        int ans[]=new int[n];
        
        for(int i=0; i<n; i++){
            root.insert(words[i]);
        }
        
        for(int i=0; i<n; i++){
            
            ans[i]=root.startsWith(words[i]);
        }
        
        return ans;
    }
}