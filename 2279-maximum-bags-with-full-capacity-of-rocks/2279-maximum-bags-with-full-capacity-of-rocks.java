class Solution {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < rocks.length; i++) {
            pq.offer(capacity[i] - rocks[i]);
        }
        int ans = 0;
        while (pq.size() != 0) {
            int val = pq.poll();
            if (val <= additionalRocks) {
                additionalRocks -= val;
                ans++;
            } else break;
        }
        return ans;
    }
}
