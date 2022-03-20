// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java
class Node
{
    public  int v;
    public int weight;
    
    Node(int _v, int _w) { v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getWeight() { return weight; }
}
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int key[]=new int[V];
        boolean mst[]=new boolean[V];
        int parent[]=new int[V];
        Arrays.fill(key,Integer.MAX_VALUE);
        Arrays.fill(parent,-1);
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2)->(o1.weight-o2.weight));
        parent[0]=-1;
        key[0]=0;
        pq.offer(new Node(0,key[0]));
        while(!pq.isEmpty()){
            int u=pq.poll().v;
            mst[u]=true;
        for(ArrayList<Integer> it:adj.get(u)){
            if(mst[it.get(0)]==false && it.get(1)<key[it.get(0)]){
                parent[it.get(0)]=u;
                key[it.get(0)]=it.get(1);
                pq.offer(new Node(it.get(0),key[it.get(0)]));
            }
        }
        
        }
        // System.out.println(Arrays.toString(key));
        int sum=0;
        for(int num:key) sum+=num;
        return sum;
    }
}
