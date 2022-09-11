class Solution {
    long mod=(int)1e9+7;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int arr[][]=new int[n][2];
        
        for(int i=0; i<n; i++){
            arr[i]=new int[]{efficiency[i],speed[i]};
        }
        
        Arrays.sort(arr,(o1,o2)->(o2[0]-o1[0])); // Sorting vie efficiency so that we get minimum effciency at the same time when we are dealing with elemnt in preorty queue
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(a, b) -> a - b);
        
        long res=0,cur_res=0;
        
        
        for(int sub[]:arr){
            pq.add(sub[1]);  
            cur_res+=sub[1];
            if(pq.size()>k) cur_res-=pq.poll(); //this will substract minimum speed value from the queue
            res=Math.max(res,(cur_res*sub[0])); // here we are multiplying sub[0] with the sum blindly ,that's why we have sorted the array acording to the efficiency in line no 10 
        }
        
        return (int)(res%mod);
        
    }
}