class Solution {
    public String removeStars(String s) {
        Deque<Character> dq = new LinkedList<Character>();
        for(char ch:s.toCharArray()){
            if(ch!='*') dq.addLast(ch);
            else dq.removeLast();
        }
        StringBuilder sb=new StringBuilder();
        
        while(!dq.isEmpty()) 
            sb.append(dq.removeFirst());
        
        return sb.toString();
    }
}