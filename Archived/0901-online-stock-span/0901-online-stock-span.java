class StockSpanner {
    Stack<int[]> st;
    int idx;

    public StockSpanner() {
        st = new Stack<>();
        idx = 0;
    }

    public int next(int price) {
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }

        int ans = 0;
        if (st.isEmpty()) {
            ans = idx + 1;
        } else {
            ans = idx-st.peek()[1];
        }
        st.push(new int[] { price, idx++ });
        return ans;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
