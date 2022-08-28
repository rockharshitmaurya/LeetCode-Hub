class Solution {
    public String removeStars(String s) {
       Stack<Character> st=new Stack<>();
        // Deque<Character> dq = new LinkedList<String>();
        for(char ch:s.toCharArray()){
            if(ch!='*') st.push(ch);
            else{
                if(st.size()>0) st.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        
        while(st.size()>0){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}