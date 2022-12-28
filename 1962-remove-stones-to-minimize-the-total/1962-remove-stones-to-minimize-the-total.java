class Solution {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        for (int num : piles) {
            pq.offer(num);
        }

        while (k-- > 0) {
            pq.offer((pq.poll() + 1) / 2);
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}
