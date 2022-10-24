//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
        return findTheCity(n,edges,distanceThreshold);
      }
          public int findTheCity(int n, int[][] edges, int dt) {
        int matrix[][]=new int[n][n];
        for(int arr[]:matrix) Arrays.fill(arr,100000000);
        
        
        for(int arr[]:edges){
            matrix[arr[0]][arr[1]]=matrix[arr[1]][arr[0]]=arr[2];
        }
        for(int i=0; i<n; i++) matrix[i][i]=0;
        for(int vie=0; vie<n; vie++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][vie]+matrix[vie][j]);
                }
            }
        }
        int reach=n,ans=0;
        for(int i=0; i<n; i++){
            int count=0;
            for(int j=0; j<n; j++){
                if(matrix[i][j]<=dt){
                    count++;
                }
            }
            if(count<=reach){
                reach=count;
                ans=i;
            }
        }
        return ans;
    }
}
