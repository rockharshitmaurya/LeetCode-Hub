class Solution {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        char str[] = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(' || str[i] == ')') {
                if (!st.isEmpty() && str[st.peek()] == '(' && str[i] == ')') {
                    set.remove(st.pop());
                } else if (str[i] == '(') {
                    st.push(i);
                    set.add(i);
                }else{
                    set.add(i);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        
        for(int i=0; i<str.length; i++){
            if(!set.contains(i)){
                ans.append(str[i]);
            }
        }
        // System.out.println(set);
        return ans.toString();
    }
}
