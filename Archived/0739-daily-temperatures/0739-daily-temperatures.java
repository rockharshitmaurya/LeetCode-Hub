class Solution {

    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();

        int n = temp.length;
        int ans[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && temp[st.peek()] <= temp[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }

        return ans;
    }
}
