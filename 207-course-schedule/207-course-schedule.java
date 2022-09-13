class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites)     {
      return isPossible(numCourses, prerequisites);  
    }
    
        public boolean isPossible(int N, int[][] pre)
    {
        ArrayList<Integer>[]  adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for(int arr[]:pre){
            adj[arr[0]].add(arr[1]);
        }
        
        int order[]=new int[N];
        
        for(ArrayList<Integer> child:adj){
            for(int num:child){
                order[num]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0; i<N; i++){
            if(order[i]==0){
                q.offer(i);
            }
        }
        
        int count=0;
        
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int num:adj[node]){
                if(--order[num]==0){
                    q.offer(num);
                }
            }
        }
        if(count==N) return true;
        return false;
    }
}