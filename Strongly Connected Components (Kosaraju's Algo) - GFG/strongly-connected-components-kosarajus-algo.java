//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    static Stack<Integer> st;
    static boolean vis[];
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        vis=new boolean[V];
        st=new Stack<>();
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                topoSort(adj,i);
            }
        }
        
        ArrayList<ArrayList<Integer>> transpose=new ArrayList<>();
        
        for(int i=0; i<V; i++){
            transpose.add(new ArrayList<>());
        }
        
        for(int i=0; i<V; i++){
            vis[i]=false;
            for(int u:adj.get(i)){
                transpose.get(u).add(i);
            }
        }
        
        int ans=0;
        
        
        while(!st.isEmpty()){
            int node=st.pop();
            if(!vis[node]){
                DFS(transpose,node); ans++;
            }
        }
        
        return ans;
        
        //code here
    }
   static  void DFS(ArrayList<ArrayList<Integer>> adj,int root){
        vis[root]=true;
        
        for(int child:adj.get(root)){
            if(!vis[child])
                DFS(adj,child);
        }
    }
    
    static void topoSort(ArrayList<ArrayList<Integer>> adj,int root){
        vis[root]=true;
        
        for(int child:adj.get(root)){
            if(!vis[child])
                topoSort(adj,child);
        }
        st.push(root);
    }
}
