class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((o1,o2)->(o2-o1));
        for(int arr[]:matrix){
            for(int num:arr){
                pq.add(num);
                if(pq.size()>k) pq.poll();
            }
        }
        // while(k-->1) pq.poll();
        return pq.peek();
    }
}