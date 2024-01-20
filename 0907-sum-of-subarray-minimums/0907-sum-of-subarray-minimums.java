class Solution {

    public int sumSubarrayMins(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length, M = (int) 1e9 + 7;
        long res = 0;
        for (int i = 0; i <= n; i++) {
            int buff = i == n ? 0 : A[i];
            while (!stack.isEmpty() && buff < A[stack.peek()]) {
                int idx = stack.pop();
                long left = idx - (stack.isEmpty() ? -1 : stack.peek());
                long right = i - idx;
                res = (res + A[idx] * left * right) % M;
            }
            stack.push(i);
        }
        return (int)res;
    }
}
