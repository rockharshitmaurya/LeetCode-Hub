class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        // int res = 0;
        for (String ele : tokens) {
            if (ele.equals("*")) {
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1 * num2);
            } else if (ele.equals("+")) {
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1 + num2);
            } else if (ele.equals("-")) {
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1 - num2);
            } else if (ele.equals("/")) {
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1 / num2);
            } else {
                st.push(Integer.parseInt(ele));
            }
        }

        return st.peek();
    }
}
