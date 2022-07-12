// { Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    int dp[][];
    public int cutRod(int price[], int n) {
        dp=new int[n][n+1];
        for(int sub[]:dp) Arrays.fill(sub,-1);
        int arr[]=new int[n];
        for(int i=0; i<n; i++) arr[i]=i+1;
        return helper(arr,n-1,price,n);
    }
    int helper(int arr[],int idx,int price[],int sum){
        if(idx==0){
            // if(sum%arr[0]==0) 
            return price[0]*(sum/1);
            // return 0;
        }
        if(dp[idx][sum]!=-1) return dp[idx][sum];
        int pick=0;
        if(arr[idx]<=sum) pick=price[idx]+helper(arr,idx,price,sum-arr[idx]);
        int notPick=helper(arr,idx-1,price,sum);
        return dp[idx][sum]=Math.max(pick,notPick);
    }
}