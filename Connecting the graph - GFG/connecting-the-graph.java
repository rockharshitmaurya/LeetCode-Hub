//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            
            Solution obj = new Solution();
            int ans = obj.Solve(n,edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
        int parent[];
    void union(int u,int v){
        int a=find(u);
        int b=find(v);
        parent[a]=b;
    }
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    public int makeConnected(int n, int[][] connections) {
        parent=new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        
        int avl=0;
        
        for(int arr[]:connections){
            if(find(arr[0])!=find(arr[1])) union(arr[0],arr[1]);
            else avl++;
        }
        int comp=0;
        for(int i=0; i<n; i++){
            if(parent[i]==i) comp++;
        }
        
        
        

        return (avl>=comp-1)?(comp-1):-1;
    }
    public int Solve(int n, int[][] edge) {
            return makeConnected(n,edge);
    }
}