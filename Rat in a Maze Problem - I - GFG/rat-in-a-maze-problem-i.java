// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans=new ArrayList<>();
        helper(m,0,0,n,ans,new String());
        return ans;
    }
    static void helper(int m[][],int row,int col,int n,ArrayList<String> ans,String str){
        if(row<0 || col<0 || row>=n || col>=n || m[row][col]==0) return; 
        if(row==n-1 && col==n-1){
            ans.add(str);
            // System.out.println(str);
            return;
        }
        m[row][col]=0;
        helper(m,row+1,col,n,ans,str+"D");
        helper(m,row,col+1,n,ans,str+"R");
        helper(m,row-1,col,n,ans,str+"U");
        helper(m,row,col-1,n,ans,str+"L");
        m[row][col]=1;
    }
}