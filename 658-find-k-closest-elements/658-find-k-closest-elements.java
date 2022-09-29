class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->((o1[0]!=o2[0])?(o1[0]-o2[0]):(o1[1]-o2[1])));
        
        for(int num:arr){
            pq.add(new int[]{Math.abs(num-x),num});
        }
        
        while(k-->0){
            ans.add(pq.poll()[1]);
        }
        Collections.sort(ans);
        return ans;
    }
}