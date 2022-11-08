class Solution {

    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && ok(st.peek(), ch)) {
                st.pop();
                continue;
            }
            st.push(ch);
        }
        String ans="";
        while(!st.isEmpty()) ans = st.pop()+ans;
        return ans;
    }

    boolean ok(char ch1, char ch2) {
        if (ch1 == ch2) return false;
        int one = ch1, two = ch2;
        if (Character.isUpperCase(ch1)) one = ch1 - 'A'; else one = ch1 - 'a';
        if (Character.isUpperCase(ch2)) two = ch2 - 'A'; else two = ch2 - 'a';
        return one == two;
    }
}
