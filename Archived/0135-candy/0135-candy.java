class Solution {

    public int candy(int[] ratings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        int n = ratings.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { ratings[i], i });
        }
        int sum = 0;
        int candies[] = new int[n];
        Arrays.fill(candies, 1);
        while (!pq.isEmpty()) {
            int arr[] = pq.poll();
            int val = arr[0];
            int idx = arr[1];
            if (idx + 1 < n && ratings[idx] > ratings[idx + 1]) {
                candies[idx] = Math.max(candies[idx], candies[idx + 1] + 1);
            }

            if (idx - 1 > -1 && ratings[idx] > ratings[idx - 1]) {
                candies[idx] = Math.max(candies[idx], candies[idx - 1] + 1);
            }
        }

        for (int num : candies) {
            sum += num;
        }
        // System.out.println(Arrays.toString(candies));
        return sum;
    }
}
// [5,4,3,2,1]
// [1,1,1,2,1]
