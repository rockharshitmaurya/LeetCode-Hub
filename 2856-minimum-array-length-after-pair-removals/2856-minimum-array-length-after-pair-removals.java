class Solution {

    public int minLengthAfterRemovals(List<Integer> input) {
        Map<Integer, Integer> hashFrq = new HashMap<>();
        for (int num : input) {
            hashFrq.put(num, hashFrq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(hashFrq.values());

        while (maxHeap.size() > 1) {
            int first_max = maxHeap.poll();
            int second_max = maxHeap.poll();

            first_max--;
            second_max--;
            if (first_max != 0) maxHeap.offer(first_max);
            if (second_max != 0) maxHeap.offer(second_max);
        }

        int sum = 0;

        while (maxHeap.size() > 0) {
            sum += maxHeap.poll();
        }

        return sum;
    }
}
