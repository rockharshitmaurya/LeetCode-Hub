class Solution {
    public String reverseWords(String s) {
     StringBuilder temp=new StringBuilder(),ans=new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            
            if(ch!=' '){
                temp.append(ch);
                continue;
            }
            
            ans.append(temp.reverse()); ans.append(" "); temp=new StringBuilder();
        }
        ans.append(temp.reverse());
        return ans.toString();
    }
}