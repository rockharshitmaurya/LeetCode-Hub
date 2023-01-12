class Solution {
    int max = 0, ans[];

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        helper(numArrows, aliceArrows, new int[12], 0, 0);
        return ans;
    }

    void helper(int arrow, int alice[], int bob[], int idx, int sum) {
        if (idx == alice.length) {
            if (arrow < 0) return;

            if (sum > max) {
                max = sum;
                ans = bob.clone();
                ans[0] += arrow;
            }

            return;
        }

        bob[idx] = alice[idx] + 1;
        helper(arrow - bob[idx], alice, bob, idx + 1, sum + idx);
        bob[idx] = 0;
        helper(arrow, alice, bob, idx + 1, sum);
    }
}
