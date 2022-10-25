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
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
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
        parent[b]=a;
    }
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    HashMap<Integer,Integer> map=new HashMap<>(); 
    int score=0;
    public int MaxConnection(int grid[][]) {
        
        int n=grid[0].length,m=grid[0].length;
        parent=new int[n*m];
        for(int i=0; i<n*m; i++){
            parent[i]=i;
        }
        
        boolean vis[][]=new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]) continue;
                
                if(grid[i][j]==1){
                   score=0;
                   
                   helper(i,j,vis,grid,(i*m)+j); 
                   map.put((i*m)+j,score);
                }
            }
        }

        int ans=1;
        int dirs[][]={{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0){
                    int res=1;
                    HashSet<Integer> set=new HashSet<>();
                    for(int arr[]:dirs){
                        int row=i+arr[0];
                        int col=j+arr[1];
                        if(row<0 || col<0 || row==n || col==m || grid[row][col]==0) continue;
                        
                        int root= (i * m) + j;
                        int node= (row * m) + col;
            
                         int key=find(node);
                         if(set.contains(key)) continue;
                         res  = res + map.get(key);
                        set.add(key);
                    }
                    
                    ans = Math.max (ans , res);
                }
            }
        }
        return ans;
    }
    
    void helper(int i,int j,boolean vis[][],int grid[][],int root){
        if(i<0 || j<0 || i==vis.length || j==vis[0].length || grid[i][j]==0 || vis[i][j]) return;
                
            vis[i][j]=true;
            score++;
            union(root,(i*grid[0].length)+j);
        
            helper(i+1,j,vis,grid,root);
            helper(i,j+1,vis,grid,root);
            helper(i-1,j,vis,grid,root);
            helper(i,j-1,vis,grid,root);
        
    }
    
}