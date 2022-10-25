//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

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
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
            boolean vis[][]=new boolean[rows][cols];
            List<Integer> ans=new ArrayList<>();
            parent=new int[rows*cols];
            for(int i=0; i<parent.length; i++){
                parent[i]=i;
            }
            int count=0;
            int dirs[][]={{0,1},{1,0},{-1,0},{0,-1}};
            for(int arr[]:operators){
                int i=arr[0];
                int j=arr[1];
                if(vis[i][j]) {
                    ans.add(count);
                  continue;  
                }
                else vis[i][j]=!vis[i][j];
                
                int root=(i*cols)+j;
                
                count = count + 1;
                
                for(int nib[]:dirs){
                    int nrow=nib[0]+i;
                    int ncol=nib[1]+j;
                    
                    if(nrow<0 || ncol<0 || nrow==rows || ncol==cols || vis[nrow][ncol]==false) continue;
                    
                    int node = (nrow*cols) + ncol;
                    
                    if(find(root)==find(node)) continue;
                    
                    union(node,root); count--;
                    
                }
                
                ans.add(count);
            }
            
            
            return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends