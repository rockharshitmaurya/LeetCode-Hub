class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int arr[]:matrix){
            for(int num:arr){
                pq.add(num);
            }
        }
        while(k-->1) pq.poll();
        return pq.peek();
    }
}