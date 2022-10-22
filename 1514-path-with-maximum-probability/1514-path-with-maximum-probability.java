class Solution {
    public double maxProbability(int n, int[][] edges, double[] sp, int start, int end) {
        ArrayList<ArrayList<double[]>> adj=new ArrayList<>();
        
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        for(int i=0; i<edges.length; i++){
            int arr[]=edges[i];
            adj.get(arr[0]).add(new double[]{arr[1],sp[i]});
            adj.get(arr[1]).add(new double[]{arr[0],sp[i]});
        }
        double p[]=new double[n];
        p[start]=1;
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a, b) -> ((int)((b[1] - a[1]) * 1000000000)));
        
        pq.offer(new double[]{start,1});
        
        
        while(!pq.isEmpty()){
            int node=(int)pq.peek()[0];
            double pb=pq.poll()[1];
            // System.out.println(node);
            if(node==end) return pb;
            for(double arr[]:adj.get(node)){
                if(pb*arr[1]>p[(int)arr[0]]){
                    p[(int)arr[0]]=pb*arr[1];
                    pq.offer(new double[]{arr[0],p[(int)arr[0]]});
                }
            }
        }
        // System.out.println(Arrays.toString(p));
        return 0D;
    }
}