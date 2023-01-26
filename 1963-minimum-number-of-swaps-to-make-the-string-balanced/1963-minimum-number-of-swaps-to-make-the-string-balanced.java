class Solution {

    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (st.size() > 0 && st.peek() == '[' && ch == ']') {
                st.pop();
                continue;
            }
            st.push(ch);
        }

        return ((st.size() / 2) + 1) / 2;
    }
}
