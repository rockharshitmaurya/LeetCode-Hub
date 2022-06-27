// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        return helper(graph,new int[n],m,n,0);
    }
    boolean helper(boolean graph[][],int col[],int m,int n,int idx){
        if(idx==n) return true;
        
        for(int i=1; i<=m; i++){ //trying for each colour
            if(isSafe(graph,col,i,idx)){ //is placing the colour isSafe(no adjcent node have same color) then we will color the node wich particlar color
                col[idx]=i;
                if(helper(graph,col,m,n,idx+1)) return true; //if this returns true this means we have sucessfully colord our graph
                else col[idx]=0; //if it is not possble
            }
        }
        return false;
    }
    boolean isSafe(boolean graph[][],int col[],int color,int idx){
            for(int i=0; i<graph.length; i++){
                if(graph[idx][i]){
                    if(col[i]==color) return false;
                }
            }
            return true;
    }
}