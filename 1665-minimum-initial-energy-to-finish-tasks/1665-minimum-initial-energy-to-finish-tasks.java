class Solution {

    public int minimumEffort(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (Math.abs(o2[1]-o2[0]) - Math.abs(o1[1]-o1[0])));
        int ans = 0, cur = 0;

        for (int arr[] : tasks) pq.offer(arr);

        while (!pq.isEmpty()) {
            int arr[] = pq.poll();

            int left = Math.max(0, arr[1] - cur);
            ans+=left;
            cur+=left;
            
            cur-=arr[0];
            
        }
        
        return ans;
    }
}
// 12 9 8 3 1

// 2 2 1 2 1

// 3 2 10 9 8
