class Solution {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    int INF = Integer.MAX_VALUE;

    public long totalCost(int[] costs, int k, int candi) {
        pq1 = new PriorityQueue<>();
        pq2 = new PriorityQueue<>();
        int i = 0, j = costs.length - 1;
        long ans = 0;
        while (i <= j && k != 0) {
            if (pq1.size() < candi) {
                if (costs[i] == -1) return overlapped(ans, k);
                pq1.offer(costs[i++]);
                costs[i - 1] = -1;
            }
            if (pq2.size() < candi) {
                if (costs[j] == -1) return overlapped(ans, k);
                pq2.offer(costs[j--]);
                costs[j + 1] = -1;
            }

            if (pq1.size() < candi || pq2.size() < candi) continue;
            // System.out.println("HI");
            int min1 = pq1.peek();
            int min2 = pq2.peek();

            if (min1 <= min2) {
                pq1.poll();
                ans += min1;
            } else {
                pq2.poll();
                ans += min2;
            }
            k--;
        }

        return overlapped(ans, k);
    }

    long overlapped(long ans, int k) {
        // System.out.println(pq1 + "---" + pq2 + "---" + k + " " + ans);
        while (k-- > 0) {
            int min1 = pq1.size() == 0 ? INF : pq1.peek();
            int min2 = pq2.size() == 0 ? INF : pq2.peek();
            if (min1 <= min2) {
                pq1.poll();
                ans += min1;
            } else {
                pq2.poll();
                ans += min2;
            }
            // System.out.println(ans);
        }
        return ans;
    }
}
