class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            pq.add(dist[i] * 1.0 / speed[i]);
        }
        
        double min = 0.0;
        int count = 0;
        while (!pq.isEmpty() && pq.poll() > min) {
            min += 1.0;
            count++;
        }
        
        return count;
    }
}