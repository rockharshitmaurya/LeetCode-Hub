class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> height = new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        for(int arr[]:buildings){
            height.add(new int[]{arr[0],-arr[2]});
            height.add(new int[]{arr[1],arr[2]}); 
        }
        
        Collections.sort(height,(o1,o2)->{
            if(o1[0]!=o2[0]){
                return o1[0]-o2[0];
            }else{
                return o1[1]-o2[1];
            }
        });
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->(o2-o1));
        TreeMap<Integer,Integer> q=new TreeMap<>();
        pq.add(0);
        q.put(0,1);
        int max=0;
        for(int arr[]:height){
            if(arr[1]<0){
                // pq.offer(-arr[1]);
                q.put(-arr[1],q.getOrDefault(-arr[1],0)+1);
            }else{
                // pq.remove(arr[1]);
                if(q.get(arr[1])==1) q.remove(arr[1]);
                else q.put(arr[1],q.getOrDefault(arr[1],0)-1);
            }
            
            int cur_max=q.lastKey();
            
            
            if(max!=cur_max){
                // System.out.println("HI");
                ans.add(Arrays.asList(arr[0],cur_max));
                max=cur_max;
            }
        }
        
        return ans;
    }
}