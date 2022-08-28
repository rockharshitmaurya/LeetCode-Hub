public String removeStars(String s) {
Stack<Character> st=new Stack<>();
for(char ch:s.toCharArray()){
if(ch!='*') st.push(ch);
else st.pop();
}
StringBuilder sb=new StringBuilder();
while(st.size()>0)
sb.append(st.pop());
return sb.reverse().toString();
}
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