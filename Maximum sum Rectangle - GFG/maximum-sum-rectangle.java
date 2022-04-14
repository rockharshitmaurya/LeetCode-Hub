// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {

        int ans=Integer.MIN_VALUE;
        for(int i=0; i<R; i++){
            int arr[]=new int[C];
            for(int j=i; j<R; j++){
                for(int col=0; col<C; col++){
                    arr[col]+=M[j][col];
                }
                ans=Math.max(ans,maxSum(arr));
            }
            
        }
        return ans;
    }
    int maxSum(int arr[]){
        int max_sum=Integer.MIN_VALUE,cur_sum=0;
        for(int num:arr){
            cur_sum+=num;
            max_sum=Math.max(max_sum,cur_sum);
            if(cur_sum<0){
                cur_sum=0;
            }
        }
        return max_sum;
    }
};