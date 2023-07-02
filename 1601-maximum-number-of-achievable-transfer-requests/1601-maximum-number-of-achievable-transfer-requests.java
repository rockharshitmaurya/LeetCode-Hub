class Solution {
    int ans = 0;

    public int maximumRequests(int n, int[][] requests) {
        helper(0,requests,new int[n],0);
        return ans;
    }

    void helper(int idx, int[][] requests, int ind[], int request) {
        if (idx == requests.length) {
            for (int num : ind) {
                if (num != 0) return;
            }
            ans = Math.max(ans, request);
            return;
        }

        helper(idx + 1, requests, ind, request);
        int from = requests[idx][0];
        int to = requests[idx][1];

        ind[from]--;
        ind[to]++;
        helper(idx + 1, requests, ind, request+1);
        ind[from]++;
        ind[to]--;
    }
}
