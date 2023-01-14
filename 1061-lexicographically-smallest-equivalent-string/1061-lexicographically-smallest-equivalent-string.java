class Solution {
    int parent[]=new int[26],map[]=new int[26];
    int find(int x,int min) {
        if (parent[x] == x) {
            map[x]=Math.min(map[x],min);
            return x;
        }
        return parent[x] = find(parent[x],Math.min(min,parent[x]));
    }
    
    void union(int a,int b){
        int x=find(a,a);
        int y=find(b,b);
        map[y]=Math.min(map[x],map[y]);
        parent[x]=y;
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(int i=0; i<26; i++){
           map[i]=parent[i]=i;
        }

        for(int i=0; i<s1.length(); i++){
            union(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(char ch:baseStr.toCharArray()){
            sb.append((char)(map[find(ch-'a',ch-'a')]+'a'));
        }
        
        return sb.toString();
    }
}
