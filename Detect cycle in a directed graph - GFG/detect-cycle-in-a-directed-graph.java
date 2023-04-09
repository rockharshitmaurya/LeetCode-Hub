//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            int topo[]=new int[V];
            for(ArrayList<Integer> sub:adj){
                for(int node:sub){
                    topo[node]++;
                }
            }
            // for(int i=0; i<V; i++)
            //     getTopo(adj,i,topo);
            
            Queue<Integer> q=new LinkedList<>();
            
            for(int i=0; i<V; i++){
                if(topo[i]==0) q.offer(i);
            }
            
            int vertex=0;
            
            while(!q.isEmpty()){
                int node=q.poll();
                vertex++;
                for(int child:adj.get(node)){
                    if(--topo[child]==0){
                        q.offer(child);
                    }
                }
            }
            
            return vertex!=V;
    }
    
    void getTopo(ArrayList<ArrayList<Integer>> adj,int root,int topo[]){
            
            for(int child:adj.get(root)){
                if(topo[child]==-1)
                    getTopo(adj,child,topo);
            }
            
            topo[root]++;
    }
    
   
}